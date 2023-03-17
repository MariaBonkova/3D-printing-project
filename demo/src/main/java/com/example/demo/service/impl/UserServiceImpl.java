package com.example.demo.service.impl;

import com.example.demo.models.dto.UserRegisterDto;
import com.example.demo.models.entity.UserEntity;
import com.example.demo.models.entity.UserRoleEntity;
import com.example.demo.models.entity.enums.UserRoleEnum;
import com.example.demo.repositopy.UserRepository;
import com.example.demo.repositopy.UserRoleRepository;

import com.example.demo.service.UserService;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
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
                userEntity.setUserName(registrationDTO.getUserName());
                userEntity.setPhoneNumber(registrationDTO.getPhoneNumber());
                userEntity.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
                userEntity.setConfirmPassword(passwordEncoder.encode(registrationDTO.getConfirmPassword()));

        userRepository.save(userEntity);

        UserDetails userDetails = userDetailsService.loadUserByUsername(registrationDTO.getEmail());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        successfulLoginProcessor.accept(authentication);
    }




  /* public boolean login(UserLoginDto userLoginDto) {
        Optional<UserEntity> userOpt = userRepository.
                findByEmail(userLoginDto.getUserName());
        if (userOpt.isEmpty()) {
            LOGGER.info("User with this email [{}] not found", userLoginDto.getUserName());
            return false;
        }
        return userOpt.get().getPassword().equals(userLoginDto.getPassword());
    }*/




}
