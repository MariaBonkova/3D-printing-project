package com.example.demo.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginDto {
    private String userName;
    private String password;

    public UserLoginDto() {
    }

    @NotBlank(message = "Задължително поле")
    @Size(min = 2, max = 10, message = "Юзър нейма трябва да съдържа от 2 до 20 символа")
    public String getUserName() {
        return userName;
    }

    public UserLoginDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @NotBlank(message = "Задължително поле")
    @Size(min = 2, max = 10, message = "Паролата трябва да съдържа от 2 до 10 символа")
    public String getPassword() {
        return password;
    }

    public UserLoginDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
