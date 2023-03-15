package com.example.demo.service.impl;

import com.example.demo.models.entity.UserRoleEntity;
import com.example.demo.models.entity.enums.UserRoleEnum;
import com.example.demo.repositopy.UserRoleRepository;
import com.example.demo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleServiceImpl implements RoleService {
    private final UserRoleRepository roleRepository;

    public RoleServiceImpl(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRole() {
        if (roleRepository.count()!=0){
            return;
        }
        Arrays.stream(UserRoleEnum.values())
                .forEach(roleEnum -> {
                    UserRoleEntity userRoleEntity = new UserRoleEntity();
                    userRoleEntity.setRole(roleEnum);
                    roleRepository.save(userRoleEntity);
                });

    }
}
