package com.example.demo.service;

import com.example.demo.models.dto.CreateOfferDto;
import com.example.demo.models.entity.CreateOfferEntity;

import java.math.BigDecimal;

public interface CreateOfferService {

    void createOffer(CreateOfferDto createOfferDto);

    Object getTotalPrice(CreateOfferEntity createOfferEntity);

}
