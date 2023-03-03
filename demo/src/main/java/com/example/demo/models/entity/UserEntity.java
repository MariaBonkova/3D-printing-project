package com.example.demo.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.apache.tomcat.util.descriptor.web.SecurityRoleRef;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

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
    private boolean gift; // по подразбиране фолз
    private List<UserRoleEntity> userRoleEntityList = new ArrayList<>();


    public UserEntity() {
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

    @Column(name = "country", nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "town", nullable = false)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Column(name = "postCode", nullable = false)
    public String getPostCode() {
        return postCode;
    }

    public UserEntity setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    @Column(name = "delivery_address", nullable = false)
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public UserEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(name = "is_gift")
    public boolean isGift() {
        return gift;
    }

    public void setGift(boolean gift) {
        this.gift = gift;
    }

    @ManyToMany
    @Enumerated(EnumType.STRING)
    public List<UserRoleEntity> getUserRoleEntityList() {
        return userRoleEntityList;
    }

    public UserEntity setUserRoleEntityList(List<UserRoleEntity> userRoleEntityList) {
        this.userRoleEntityList = userRoleEntityList;
        return this;
    }
}
