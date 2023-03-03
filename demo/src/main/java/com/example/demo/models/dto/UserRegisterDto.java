package com.example.demo.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private String confirmPassword;
    private String country;
    private String town;
    private String postCode;
    private String deliveryAddress;
    private String description;

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
    @Size(min = 2,max = 10,message = "Password must be between 2 and 10 characters")
    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }
    @NotBlank(message = "Required field")
    @Size(min = 2,max = 10,message = "Password must be between 2 and 10 characters")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @NotBlank(message = "Required field")
    public String getCountry() {
        return country;
    }

    public UserRegisterDto setCountry(String country) {
        this.country = country;
        return this;
    }
    @NotBlank(message = "Required field")
    public String getTown() {
        return town;
    }

    public UserRegisterDto setTown(String town) {
        this.town = town;
        return this;
    }
    @NotBlank(message = "Required field")
    public String getPostCode() {
        return postCode;
    }

    public UserRegisterDto setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    @NotBlank(message = "Required field")
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public UserRegisterDto setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UserRegisterDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
