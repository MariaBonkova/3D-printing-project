package com.example.demo.service.impl;

import com.example.demo.models.dto.CreateHouseOfferDto;
import com.example.demo.models.dto.CreateOfferDto;
import com.example.demo.models.entity.CreateHouseEntity;
import com.example.demo.models.entity.CreateOfferEntity;
import com.example.demo.models.entity.PetsItemEntity;
import com.example.demo.models.view.HouseView;
import com.example.demo.models.view.MusicInstrumentView;
import com.example.demo.models.view.PetsView;
import com.example.demo.repositopy.CreateHouseRepository;
import com.example.demo.repositopy.CreateOfferRepository;
import com.example.demo.service.CreateOfferService;
import com.example.demo.service.MaterialService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CreateOfferServiceImpl implements CreateOfferService {

    private final MaterialService materialService;
    private final CreateOfferRepository createOfferRepository;
    private final ModelMapper modelMapper;
    private final CreateHouseRepository createHouseRepository;


    public CreateOfferServiceImpl(MaterialService materialService,
                                  CreateOfferRepository createOfferRepository, ModelMapper modelMapper, CreateHouseRepository createHouseRepository) {
        this.materialService = materialService;
        this.createOfferRepository = createOfferRepository;
        this.modelMapper = modelMapper;
        this.createHouseRepository = createHouseRepository;
    }


    public void createOffer(CreateOfferDto createOfferDto) {

        CreateOfferEntity createOfferEntity = modelMapper.map(createOfferDto, CreateOfferEntity.class);

        BigDecimal materialEntitiesByPrice = materialService.findPriceOfMaterial(createOfferDto.getMaterialComposition());

        createOfferEntity.setPrice(createOfferDto.getQuantity().multiply(materialEntitiesByPrice));


        createOfferRepository.save(createOfferEntity);


    }

    @Override
    public void createHouseOffer(CreateHouseOfferDto createHouseOfferDto) {
        CreateHouseEntity createHouseEntity = modelMapper.map(createHouseOfferDto, CreateHouseEntity.class);

        BigDecimal materialEntitiesByPrice = materialService.findPriceOfMaterial(createHouseOfferDto.getMaterialComposition());

        createHouseEntity.setPrice(createHouseOfferDto.getQuadrature()
                .multiply(materialEntitiesByPrice)
                .multiply(createHouseEntity.getFlat()));

        createHouseRepository.save(createHouseEntity);

    }

    @Override
    public PetsView getPetView(Long id) {
        Optional<CreateOfferEntity> byId = createOfferRepository.findById(id);
        CreateOfferEntity createOfferEntity = byId.get();
        return modelMapper.map(createOfferEntity, PetsView.class);


    }

    @Override
    public MusicInstrumentView getMusicView(Long id) {
        Optional<CreateOfferEntity> byId = createOfferRepository.findById(id);
        CreateOfferEntity createOfferEntity = byId.get();
        return modelMapper.map(createOfferEntity, MusicInstrumentView.class);

    }

    @Override
    public HouseView getHouseView(Long id) {
        Optional<CreateHouseEntity> byId = createHouseRepository.findById(id);
        CreateHouseEntity createHouseEntity = byId.get();
        return modelMapper.map(createHouseEntity, HouseView.class);
    }

    @Override
    public PetsView createNewItem(PetsItemEntity petsItemEntity) {
        PetsView petsView = new PetsView();
       petsView.setId(petsItemEntity.getId());
        petsView.setProductName(petsItemEntity.getTitle());
        petsView.setPrice(petsItemEntity.getPrice());
        petsView.setUrlImage(petsItemEntity.getImageUrl());

        return petsView;

    }



}
