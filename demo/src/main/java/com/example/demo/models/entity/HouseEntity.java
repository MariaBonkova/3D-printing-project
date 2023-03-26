package com.example.demo.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Date;
import java.util.function.BiConsumer;

@Entity
@Table(name = "house")
public class HouseEntity extends BaseEntity{

    private String title;
    private String imageUrl;
    private Double quadrature;
    private String description;
    private BigDecimal housePrice;

    public HouseEntity() {
    }
@Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public HouseEntity setTitle(String title) {
        this.title = title;
        return this;
    }
    @Column(nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public HouseEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
    @Column(nullable = false)
    public Double getQuadrature() {
        return quadrature;
    }

    public HouseEntity setQuadrature(Double quadrature) {
        this.quadrature = quadrature;
        return this;
    }
    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public HouseEntity setDescription(String description) {
        this.description = description;
        return this;
    }
    @Column(nullable = false)
    public BigDecimal getHousePrice() {
        return housePrice;
    }

    public HouseEntity setHousePrice(BigDecimal housePrice) {
        this.housePrice = housePrice;
        return this;
    }
}
