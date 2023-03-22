package com.example.demo.service;

import com.example.demo.models.dto.CreateOfferDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreateOfferServiceImpl implements CreateOfferService {


private final MaterialService materialService;
    private CreateOfferDto createOfferDto;

    public CreateOfferServiceImpl( MaterialService materialService) {
     this.materialService = materialService;
    }

    public BigDecimal totalProductPrice(String name){

        BigDecimal materialEntitiesByPrice = materialService.findMaterialEntitiesByPrice(name);
        BigDecimal dtoQuantity = createOfferDto.getQuantity();
        BigDecimal price = materialEntitiesByPrice * dtoQuantity;

return
    }
}
