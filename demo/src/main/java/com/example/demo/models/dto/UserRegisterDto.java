package com.example.demo.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public class UserRegisterDto {

    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private String confirmPassword;


    public UserRegisterDto() {
    }

    @NotBlank(message = "Задължително поле")
    @Size(min = 2, max = 20, message = "Името трябва да съдържа от 2 до 20 символа")
    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @NotBlank(message = "Задължително поле")
    @Size(min = 2, max = 20, message = "Фамилията трябва да съдържа от 2 до 20 символа")
    public String getLastName() {
        return lastName;
    }

    public UserRegisterDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @NotBlank(message = "Задължително поле")
    @Size(min = 2, max = 10, message = "Юзър нейма трябва да съдържа от 2 до 20 символа")
    public String getUsername() {
        return username;
    }

    public UserRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank(message = "Задължително поле")
    @Positive(message = "Полето трябва да съдържа положителни числа")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserRegisterDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @NotBlank(message = "Задължително поле")
    @Email
    public String getEmail() {
        return email;
    }

    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank(message = "Задължително поле")
    @Size(min = 2, max = 10, message = "Паролата трябва да съдържа от 2 до 10 символа")
    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank(message = "Задължително поле")
    @Size(min = 2, max = 10, message = "Паролата трябва да съдържа от 2 до 10 символа")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

}