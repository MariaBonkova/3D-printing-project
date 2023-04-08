package com.example.demo.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.*;

@Entity
@Table(name = "users")
public class UserEntity  {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private String confirmPassword;
    private UserRoleEntity userRoleEntity;
    private List<UserRoleEntity> userRoleEntityList;


    public UserEntity() {
        this.userRoleEntityList=new ArrayList<>();   }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(nullable = false,unique = true)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(name = "phone_number", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "email", nullable = false, unique = true)
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "confirm_password", nullable = false)
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserEntity setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @ManyToOne
    public UserRoleEntity getUserRoleEntity() {
        return userRoleEntity;
    }

    public UserEntity setUserRoleEntity(UserRoleEntity userRoleEntity) {
        this.userRoleEntity = userRoleEntity;
        return this;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    public List<UserRoleEntity> getUserRoleEntityList() {
        return userRoleEntityList;
    }

    public UserEntity setUserRoleEntityList(List<UserRoleEntity> userRoleEntityList) {
        this.userRoleEntityList = userRoleEntityList;
        return this;
    }
    public UserEntity addRole(UserRoleEntity role){
        this.userRoleEntityList.add(role);
        return this;
    }

//тъй като ползвам сет добавям и двата метода
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
