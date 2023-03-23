package com.example.demo.service.impl;

import com.example.demo.models.entity.CreateOfferEntity;
import com.example.demo.models.entity.MaterialEntity;
import com.example.demo.models.entity.enums.MaterialComposition;
import com.example.demo.repositopy.MaterialRepository;
import com.example.demo.service.MaterialService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class MaterialServiceImpl implements MaterialService {
private final MaterialRepository materialRepository;


    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;

    }

    @Override
    public void initPrice() {
        if (materialRepository.count()!=0){
            return;
        }
        Arrays.stream(MaterialComposition.values()).forEach(
                materialComposition -> {
                    MaterialEntity materialEntity = new MaterialEntity();
                    materialEntity.setName(materialComposition);
                    switch (materialComposition){
                        //    ABS-30, NYLON -150, PETG-50, Hips -110 POLYCARBONATE- 90,  ASA-65
                        case ABS -> materialEntity.setPrice(BigDecimal.valueOf(30));
                        case NYLON -> materialEntity.setPrice(BigDecimal.valueOf(150));
                        case PETG -> materialEntity.setPrice(BigDecimal.valueOf(50));
                        case HIPS -> materialEntity.setPrice(BigDecimal.valueOf(110));
                        case POLYCARBONATE -> materialEntity.setPrice(BigDecimal.valueOf(90));
                        case ASA -> materialEntity.setPrice(BigDecimal.valueOf(65));

                    }

                    materialRepository.save(materialEntity);

                }
        );
    }

    @Override
    public MaterialComposition findByName(MaterialComposition name) {
        materialRepository.findByName(name);
        return name;
    }

    public BigDecimal findMaterialEntitiesByPrice(String name){
        return materialRepository.findMaterialEntitiesByPrice(name);
    }


}

