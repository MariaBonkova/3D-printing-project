package com.example.demo.models.dto;

public class UserLoginDto {
    private String userName;
    private String password;

    public UserLoginDto() {
    }

    public String getUserName() {
        return userName;
    }

    public UserLoginDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
