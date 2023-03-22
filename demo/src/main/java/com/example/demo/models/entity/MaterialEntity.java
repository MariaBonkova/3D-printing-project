package com.example.demo.models.entity;

import com.example.demo.models.entity.enums.MaterialComposition;
import com.example.demo.models.entity.enums.ProductCategoryEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
@Table(name = "materials")
public class MaterialEntity extends BaseEntity{

    private MaterialComposition name;
    private BigDecimal price;//цена на ресурса от който ще се сформира крайната цена

    public MaterialEntity() {
    }
    @Enumerated(EnumType.STRING)
    public MaterialComposition getName() {
        return name;
    }

    public MaterialEntity setName(MaterialComposition name) {
        this.name = name;
        return this;
    }

@Positive
    public BigDecimal getPrice() {
        return price;
    }

    public MaterialEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }


}
