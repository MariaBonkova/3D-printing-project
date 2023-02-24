package com.example.demo.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "baskets")
public class Basket extends BaseEntity{
    List<ProductEntity> itemsOnHold;   // неща на изчакване
    private BigDecimal price;
    private UserEntity user;

}
