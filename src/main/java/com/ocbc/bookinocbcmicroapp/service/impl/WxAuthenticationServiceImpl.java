package com.ocbc.bookinocbcmicroapp.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ocbc.bookinocbcmicroapp.core.exception.ParameterException;
import com.ocbc.bookinocbcmicroapp.entity.User;
import com.ocbc.bookinocbcmicroapp.repository.UserRepository;
import com.ocbc.bookinocbcmicroapp.service.WxAuthenticationService;
import com.ocbc.bookinocbcmicroapp.util.JwtToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class WxAuthenticationServiceImpl implements WxAuthenticationService {

    private final ObjectMapper mapper;
    private final UserRepository userRepository;

    @Value("${wx.code2session}")
    private String code2sessionUrl;
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.appsecret}")
    private String appsecret;

    public WxAuthenticationServiceImpl(ObjectMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    public String code2Session(String code) {
        String url = MessageFormat.format(this.code2sessionUrl, this.appid, this.appsecret, code);
        RestTemplate rest = new RestTemplate();
        Map<String, Object> session = new HashMap<>();
        String sessionText = rest.getForObject(url, String.class);
        try {
            session = mapper.readValue(sessionText, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return this.registerUser(session);
    }

    private String registerUser(Map<String, Object> session) {
        String openid = (String) session.get("openid");
        if (null == openid) {
            throw new ParameterException(20004);
        }
        Optional<User> userOptional = this.userRepository.findByOpenid(openid);
        if (userOptional.isPresent()) {
            return JwtToken.makeToken(userOptional.get().getId());
        }
        User user = User.builder().
                openid(openid).
                build();
        userRepository.save(user);
        Long uid = user.getId();
        return JwtToken.makeToken(uid);
    }
}
