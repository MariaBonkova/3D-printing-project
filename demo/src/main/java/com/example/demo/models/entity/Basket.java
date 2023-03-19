package com.example.demo.models.entity;

import com.example.demo.models.entity.enums.ProductCategoryEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "basket")
public class Basket extends BaseEntity{

    private UserEntity user;
    private BigDecimal price;
   private Integer quantity;
   private BigDecimal deliveryPrice;
    List<ProductCategoryEnum> buyItem;

    public Basket() {
    }
@ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public Basket setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Basket setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Basket setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public Basket setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
        return this;
    }

    public List<ProductCategoryEnum> getBuyItem() {
        return buyItem;
    }

    public Basket setBuyItem(List<ProductCategoryEnum> buyItem) {
        this.buyItem = buyItem;
        return this;
    }
}
