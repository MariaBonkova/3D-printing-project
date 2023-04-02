package com.example.demo.models.dto;

import com.example.demo.models.entity.BaseProduct;
import com.example.demo.models.entity.enums.MaterialComposition;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class CreateHouseOfferDto {

    private String productName;
    private MaterialComposition materialComposition;
    private BigDecimal quadrature;
    private BigDecimal flat;
    private String description;
    private BigDecimal price;
    private String urlImage;

    public CreateHouseOfferDto() {
    }
    @Size(min = 3, max = 30)
    @Column(unique = true)
    public String getProductName() {
        return productName;
    }

    public CreateHouseOfferDto setProductName(String productName) {
        this.productName = productName;
        return this;
    }
    @Enumerated(EnumType.STRING)
    public MaterialComposition getMaterialComposition() {
        return materialComposition;
    }

    public CreateHouseOfferDto setMaterialComposition(MaterialComposition materialComposition) {
        this.materialComposition = materialComposition;
        return this;
    }
    @Positive
    public BigDecimal getQuadrature() {
        return quadrature;
    }

    public CreateHouseOfferDto setQuadrature(BigDecimal quadrature) {
        this.quadrature = quadrature;
        return this;
    }
    @Positive
    public BigDecimal getFlat() {
        return flat;
    }

    public CreateHouseOfferDto setFlat(BigDecimal flat) {
        this.flat = flat;
        return this;
    }
    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public CreateHouseOfferDto setDescription(String description) {
        this.description = description;
        return this;
    }
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public CreateHouseOfferDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public CreateHouseOfferDto setUrlImage(String urlImage) {
        this.urlImage = urlImage;
        return this;
    }
}
