package com.example.demo.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDto {

    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private String confirmPassword;


    public UserRegisterDto() {
    }

    @NotBlank(message = "Required field")
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @NotBlank(message = "Required field")
    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters")
    public String getLastName() {
        return lastName;
    }

    public UserRegisterDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @NotBlank(message = "Required field")
    @Size(min = 2, max = 10, message = "User name must be between 2 and 10 characters")
    public String getUserName() {
        return userName;
    }

    public UserRegisterDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @NotBlank(message = "Required field")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserRegisterDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @NotBlank(message = "Required field")
    @Email
    public String getEmail() {
        return email;
    }

    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank(message = "Required field")
    @Size(min = 2, max = 10, message = "Password must be between 2 and 10 characters")
    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank(message = "Required field")
    @Size(min = 2, max = 10, message = "Password must be between 2 and 10 characters")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

}