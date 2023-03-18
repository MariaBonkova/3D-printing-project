package com.example.demo.service.impl;

import com.example.demo.models.entity.UserEntity;
import com.example.demo.models.entity.UserRoleEntity;
import com.example.demo.models.entity.enums.UserRoleEnum;
import com.example.demo.repositopy.UserRepository;
import com.example.demo.repositopy.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InitService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public InitService(UserRoleRepository userRoleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           @Value("${app.default.password}") String defaultPassword) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;


    }


    @PostConstruct
    public void init() {
        initRoles();
        initUsers();
    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            var moderatorRole = new UserRoleEntity().setRole(UserRoleEnum.MODERATOR);
            var adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);

            userRoleRepository.save(moderatorRole);
            userRoleRepository.save(adminRole);
        }
    }

    private void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
            initModerator();
            initNormalUser();
        }
    }

    private void initAdmin(){
        var adminUser = new UserEntity();
        adminUser.setEmail("adminov@print.com");
        adminUser.setFirstName("Иван");
        adminUser.setLastName("Админа");
        adminUser.setUsername("admin");
        adminUser.setPassword(passwordEncoder.encode("print"));
        adminUser.setConfirmPassword(passwordEncoder.encode("print"));
        adminUser.setPhoneNumber("01235556");
        adminUser.setUserRoleEntityList(userRoleRepository.findAll());

        userRepository.save(adminUser);
    }

    private void initModerator(){

        var moderatorRole = userRoleRepository.
                findUserRoleEntityByRole(UserRoleEnum.MODERATOR).orElseThrow();

        var moderatorUser = new UserEntity();
        moderatorUser.setEmail("moderator@print.com");
        moderatorUser.setFirstName("Мишо");
        moderatorUser.setLastName("Модератора");
        moderatorUser.setUsername("moderator");
        moderatorUser.setPassword(passwordEncoder.encode("print"));
        moderatorUser.setConfirmPassword(passwordEncoder.encode("print"));
        moderatorUser.setPhoneNumber("011485");
        moderatorUser.setUserRoleEntityList(List.of(moderatorRole));

        userRepository.save(moderatorUser);
    }

    private void initNormalUser(){

        var normalUser = new UserEntity();
        normalUser.setEmail("user@example.com");
        normalUser.setFirstName("Ангел");
        normalUser.setLastName("Юзеров");
        normalUser.setUsername("ani");
        normalUser.setPassword(passwordEncoder.encode("print"));
        normalUser.setConfirmPassword(passwordEncoder.encode("print"));
        normalUser.setPhoneNumber("011485");
        userRepository.save(normalUser);
    }


}
