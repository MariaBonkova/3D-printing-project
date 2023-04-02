package com.example.demo.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.math.BigDecimal;


@MappedSuperclass
public abstract class BaseProduct extends BaseEntity{

    private String title;
    private String imageUrl;
    private BigDecimal price;

    public BaseProduct() {
    }
@Column(nullable = false,unique = true)
    public String getTitle() {
        return title;
    }

    public BaseProduct setTitle(String title) {
        this.title = title;
        return this;
    }
    @Column(nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public BaseProduct setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public BaseProduct setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
