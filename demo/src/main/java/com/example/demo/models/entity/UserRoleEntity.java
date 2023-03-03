package com.example.demo.models.entity;

import com.example.demo.models.entity.enums.RoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class UserRoleEntity extends BaseEntity{

    private RoleEnum role ;

    public UserRoleEntity() {
    }
    @Enumerated(EnumType.STRING)
    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

}
