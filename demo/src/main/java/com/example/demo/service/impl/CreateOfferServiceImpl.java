package com.example.demo.service.impl;

import com.example.demo.models.entity.CreateOfferEntity;
import com.example.demo.repositopy.CreateOfferRepository;
import com.example.demo.service.CreateOfferService;
import com.example.demo.service.MaterialService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreateOfferServiceImpl implements CreateOfferService {


private final MaterialService materialService;
   private final CreateOfferRepository createOfferRepository;


    public CreateOfferServiceImpl(MaterialService materialService, CreateOfferRepository createOfferRepository) {
     this.materialService = materialService;
        this.createOfferRepository = createOfferRepository;
    }

    public BigDecimal totalProductPrice(String name){

        BigDecimal materialEntitiesByPrice = materialService.findMaterialEntitiesByPrice(name);
      //  BigDecimal dtoQuantity = createOfferDto.getQuantity();
      //  BigDecimal price = materialEntitiesByPrice * dtoQuantity;

return materialEntitiesByPrice;
    }

    @Override
    public void addPrice() {
       CreateOfferEntity createOfferEntity = new CreateOfferEntity();
       createOfferRepository.findById(createOfferEntity.getId());
       createOfferEntity.setPrice(totalProductPrice(createOfferEntity.getProductName()));
    }
}
