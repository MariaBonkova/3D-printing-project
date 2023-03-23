package com.example.demo.service;

import com.example.demo.models.entity.enums.MaterialComposition;

import java.math.BigDecimal;

public interface MaterialService {
    void initPrice();

    MaterialComposition findByName(MaterialComposition materialComposition);

    BigDecimal findMaterialEntitiesByPrice(String name);
}
