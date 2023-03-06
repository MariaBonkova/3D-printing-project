package com.example.demo.models.entity;

import com.example.demo.models.entity.enums.ProductCategoryEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "baskets")
public class Basket extends BaseEntity{

    private UserEntity user;
    private BigDecimal price;
   private Integer quantity;
   private BigDecimal deliveryPrice;
    List<ProductCategoryEnum> buyItem;
}
