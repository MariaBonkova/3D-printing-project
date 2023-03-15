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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRegisterDto userRegisterDto;


    public UserServiceImpl(UserRoleRepository userRoleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           @Value("${app.default.password}") String defaultPassword, UserRegisterDto userRegisterDto) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRegisterDto = userRegisterDto;

    }
    @PostConstruct
    public void init() {
        initRoles();
        initUsers();
    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {
           var adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
            var guestRole = new UserRoleEntity().setRole(UserRoleEnum.GUEST);
            var buyerRole = new UserRoleEntity().setRole(UserRoleEnum.BUYER);
            var creatorRole = new UserRoleEntity().setRole(UserRoleEnum.CREATOR);

            userRoleRepository.save(adminRole);
            userRoleRepository.save(guestRole);
            userRoleRepository.save(buyerRole);
            userRoleRepository.save(creatorRole);
        }
    }


    private void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
            initGuest();
            initBuyer();
            initCreator();
        }
    }

    private void initCreator() {
        var creatorRole = userRoleRepository.
                findUserRoleEntityByRole(UserRoleEnum.CREATOR).orElseThrow();

        var creatorUser = new UserEntity();
        creatorUser.setFirstName(userRegisterDto.getFirstName());
        creatorUser.setLastName(userRegisterDto.getLastName());
        creatorUser.setEmail(userRegisterDto.getEmail());
        creatorUser.setPhoneNumber(userRegisterDto.getPhoneNumber());
        creatorUser.setUserName(userRegisterDto.getUserName());
        creatorUser. setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        creatorUser.setConfirmPassword(passwordEncoder.encode(userRegisterDto.getConfirmPassword()));
        creatorUser.setUserRoleEntityList(List.of(creatorRole));

        userRepository.save(creatorUser);

    }

    private void initBuyer() {
        var buyerRole = userRoleRepository.
                findUserRoleEntityByRole(UserRoleEnum.BUYER).orElseThrow();

        var buyerUser = new UserEntity();
        buyerUser.setFirstName(userRegisterDto.getFirstName());
        buyerUser.setLastName(userRegisterDto.getLastName());
        buyerUser.setEmail(userRegisterDto.getEmail());
        buyerUser.setPhoneNumber(userRegisterDto.getPhoneNumber());
        buyerUser.setUserName(userRegisterDto.getUserName());
        buyerUser. setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        buyerUser.setConfirmPassword(passwordEncoder.encode(userRegisterDto.getConfirmPassword()));
        buyerUser.setUserRoleEntityList(List.of(buyerRole));

        userRepository.save(buyerUser);

    }

    private void initGuest() {

      var guestUser = new UserEntity();
     guestUser.setFirstName (userRegisterDto.getFirstName());
        guestUser.setLastName(userRegisterDto.getLastName());
        guestUser.setEmail(userRegisterDto.getEmail());
        guestUser.setPhoneNumber(userRegisterDto.getPhoneNumber());
        guestUser.setUserName(userRegisterDto.getUserName());
        guestUser. setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        guestUser.setConfirmPassword(passwordEncoder.encode(userRegisterDto.getConfirmPassword()));
        userRepository.save(guestUser);

    }

    private void initAdmin() {
        var adminUser = new UserEntity();

        adminUser.setFirstName(userRegisterDto.getFirstName());
        adminUser.setLastName(userRegisterDto.getLastName());
        adminUser.setEmail(userRegisterDto.getEmail());
        adminUser.setPhoneNumber(userRegisterDto.getPhoneNumber());
        adminUser.setUserName(userRegisterDto.getUserName());
        adminUser. setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        adminUser.setConfirmPassword(passwordEncoder.encode(userRegisterDto.getConfirmPassword()));
        adminUser.setUserRoleEntityList(userRoleRepository.findAll());
        userRepository.save(adminUser);
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
