package com.example.demo.service;

import com.example.demo.models.dto.CreateHouseOfferDto;
import com.example.demo.models.dto.CreateOfferDto;
import com.example.demo.models.entity.CreateOfferEntity;
import com.example.demo.models.view.HouseView;
import com.example.demo.models.view.MusicInstrumentView;
import com.example.demo.models.view.PetsView;

import java.math.BigDecimal;

public interface CreateOfferService {

    void createOffer(CreateOfferDto createOfferDto);
    void createHouseOffer(CreateHouseOfferDto createHouseOfferDto);


    PetsView getPetView(Long id);

    MusicInstrumentView getMusicView(Long id);

    HouseView getHouseView(Long id);
}
