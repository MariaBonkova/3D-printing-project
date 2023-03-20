package com.example.demo.service.impl;

import com.example.demo.models.dto.UserRegisterDto;
import com.example.demo.models.entity.UserEntity;
import com.example.demo.repositopy.UserRepository;

import com.example.demo.service.UserService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;



    public UserServiceImpl(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    public void registerUser(UserRegisterDto registrationDTO,
                             Consumer<Authentication> successfulLoginProcessor) {

        UserEntity userEntity = new UserEntity();
                userEntity.setFirstName(registrationDTO.getFirstName());
                userEntity.setLastName(registrationDTO.getLastName());
                userEntity.setEmail(registrationDTO.getEmail());
                userEntity.setUsername(registrationDTO.getUsername());
                userEntity.setPhoneNumber(registrationDTO.getPhoneNumber());
                userEntity.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
                userEntity.setConfirmPassword(passwordEncoder.encode(registrationDTO.getConfirmPassword()));

        userRepository.save(userEntity);

        UserDetails userDetails = userDetailsService.loadUserByUsername(registrationDTO.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        successfulLoginProcessor.accept(authentication);
    }

}
