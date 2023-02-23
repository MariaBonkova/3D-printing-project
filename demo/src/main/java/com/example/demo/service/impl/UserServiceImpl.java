package com.example.demo.service.impl;

import com.example.demo.models.dto.UserLoginDto;
import com.example.demo.models.entity.UserEntity;
import com.example.demo.repositopy.UserRepository;
import com.example.demo.service.HomeService;
import com.example.demo.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(UserLoginDto userLoginDto) {
        Optional<UserEntity> userOpt = userRepository.
                findByEmail(userLoginDto.getEmail());
        if (userOpt.isEmpty()) {
            LOGGER.info("User with this email [{}] not found", userLoginDto.getEmail());
            return false;
        }
        return userOpt.get().getPassword().equals(userLoginDto.getPassword());
    }



}
