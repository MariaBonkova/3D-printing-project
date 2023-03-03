package com.example.demo.models.entity;

import com.example.demo.models.entity.enums.MaterialComposition;
import com.example.demo.models.entity.enums.ProductCategoryEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "materials")
public class MaterialEntity extends BaseEntity{

    private MaterialComposition materialComposition;
    private ProductCategoryEnum productCategoryEnum;
    public BigDecimal quantity;//количество
    private BigDecimal price;//цена на ресурса от който ще се сформира крайната цена

}
