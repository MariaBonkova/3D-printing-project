package com.example.demo.service.impl;

import com.example.demo.models.dto.CreateOfferDto;
import com.example.demo.models.entity.CreateOfferEntity;
import com.example.demo.models.view.CreateOfferView;
import com.example.demo.repositopy.CreateOfferRepository;
import com.example.demo.service.CreateOfferService;
import com.example.demo.service.MaterialService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreateOfferServiceImpl implements CreateOfferService {


    private final MaterialService materialService;
    private final CreateOfferRepository createOfferRepository;


    public CreateOfferServiceImpl(MaterialService materialService,
                                  CreateOfferRepository createOfferRepository) {
        this.materialService = materialService;
        this.createOfferRepository = createOfferRepository;

    }


    public void createOffer(CreateOfferDto createOfferDto){

        BigDecimal materialEntitiesByPrice = materialService.findMaterialEntitiesByPrice(createOfferDto.getProductName());

        CreateOfferEntity createOfferEntity = new CreateOfferEntity();
        createOfferEntity.setProductName(createOfferDto.getProductName());
        createOfferEntity.setMaterialComposition(createOfferDto.getMaterialComposition());
        createOfferEntity.setQuantity(createOfferDto.getQuantity());
        createOfferEntity.setPrice(createOfferDto.getQuantity().multiply(materialEntitiesByPrice));
        createOfferEntity.setUrlImage(createOfferDto.getUrlImage());

        createOfferRepository.save(createOfferEntity);



    }

    public BigDecimal getTotalPrice(CreateOfferEntity createOfferEntity){

        return  createOfferRepository.findByProductName(createOfferEntity.getProductName()).
                get().getPrice();

    }




}
