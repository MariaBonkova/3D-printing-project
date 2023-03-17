package com.example.demo.service;

import com.example.demo.models.dto.UserRegisterDto;
import com.example.demo.models.entity.UserEntity;
import com.example.demo.repositopy.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, ModelMapper modelMapper,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean register(UserRegisterDto userRegisterDto){

        if(!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            return false;
        }

        Optional<UserEntity> byEmail = this.userRepository.findByEmail(userRegisterDto.getEmail());
        if (byEmail.isPresent()){
            return false;
        }

        Optional<UserEntity> byUserName = this.userRepository.findByUserName(userRegisterDto.getUserName());
        if (byUserName.isPresent()){
            return false;
        }

        UserEntity user = modelMapper.map(userRegisterDto, UserEntity.class);


        this.userRepository.save(user);
        return true;
    }
}
