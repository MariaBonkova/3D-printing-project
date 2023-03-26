package com.example.demo.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;


@Entity
@Table(name = "pets_items")
public class PetsItemEntity extends BaseEntity{

    private String title;
    private String imageUrl;
    private String description;
    private BigDecimal petsPrice;

    public PetsItemEntity() {
    }
    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public PetsItemEntity setTitle(String title) {
        this.title = title;
        return this;
    }
    @Column(nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public PetsItemEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public PetsItemEntity setDescription(String description) {
        this.description = description;
        return this;
    }
    @Column(nullable = false)
    public BigDecimal getPetsPrice() {
        return petsPrice;
    }

    public PetsItemEntity setPetsPrice(BigDecimal petsPrice) {
        this.petsPrice = petsPrice;
        return this;
    }
}
