package com.ocbc.bookinocbcmicroapp.controller.v1;

import com.ocbc.bookinocbcmicroapp.constant.LoginType;
import com.ocbc.bookinocbcmicroapp.core.exception.NotFoundException;
import com.ocbc.bookinocbcmicroapp.dto.TokenDTO;
import com.ocbc.bookinocbcmicroapp.dto.TokenGetDTO;
import com.ocbc.bookinocbcmicroapp.service.WxAuthenticationService;
import com.ocbc.bookinocbcmicroapp.util.JwtToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/v1/token")
@RestController
public class TokenController {

    final
    WxAuthenticationService wxAuthenticationService;

    public TokenController(WxAuthenticationService wxAuthenticationService) {
        this.wxAuthenticationService = wxAuthenticationService;
    }

    @PostMapping("")
    public Map<String, String> getToken(@RequestBody @Validated TokenGetDTO userData) {
        Map<String, String> map = new HashMap<>();
        String token;
        switch (LoginType.getLoginType(userData.getType().getValue())) {
            case USER_WX:
                token = wxAuthenticationService.code2Session(userData.getAccount());
                break;
            case USER_Email:
            case USER_Phone:
            default:
                throw new NotFoundException(10003);
        }
        map.put("token", token);
        return map;
    }

    @PostMapping("/verify")
    public Map<String, Boolean> verify(@RequestBody TokenDTO token) {
        Map<String, Boolean> map = new HashMap<>();
        Boolean valid = JwtToken.verifyToken(token.getToken());
        map.put("is_valid", valid);
        return map;
    }
}
