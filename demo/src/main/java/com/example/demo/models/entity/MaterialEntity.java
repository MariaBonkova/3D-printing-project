package com.example.demo.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "materials")
public class MaterialEntity extends BaseEntity{

    private String name;
    public BigDecimal quantity;//количество
    private BigDecimal price;//цена на ресурса от който ще се сформира крайната цена

}
