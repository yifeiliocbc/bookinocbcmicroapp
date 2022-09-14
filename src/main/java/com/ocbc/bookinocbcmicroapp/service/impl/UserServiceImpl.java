package com.ocbc.bookinocbcmicroapp.service.impl;

import com.ocbc.bookinocbcmicroapp.entity.User;
import com.ocbc.bookinocbcmicroapp.repository.UserRepository;
import com.ocbc.bookinocbcmicroapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findFirstById(id);
    }
}
