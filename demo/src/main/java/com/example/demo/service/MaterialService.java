package com.example.demo.service;

import com.example.demo.models.entity.enums.MaterialComposition;

import java.math.BigDecimal;

public interface MaterialService {
    void initPrice();

    BigDecimal findPriceOfMaterial(MaterialComposition materialComposition);


    MaterialComposition findByName(MaterialComposition name);

}
