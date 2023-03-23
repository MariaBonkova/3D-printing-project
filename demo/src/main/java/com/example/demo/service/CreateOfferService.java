package com.example.demo.service;

import com.example.demo.models.entity.CreateOfferEntity;

import java.math.BigDecimal;

public interface CreateOfferService {

     BigDecimal totalProductPrice(String name);

    void addPrice();
}
