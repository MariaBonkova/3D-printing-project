package com.example.demo.models.dto;

import com.example.demo.models.entity.enums.MaterialComposition;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class CreateOfferDto {

    private String productName;
    private MaterialComposition materialComposition;
    private BigDecimal quantity;
    private String description;
    private BigDecimal price;
    private String urlImage;

    public CreateOfferDto() {
    }

    @Size(min = 3, max = 30)
    public String getProductName() {
        return productName;
    }

    public CreateOfferDto setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public MaterialComposition getMaterialComposition() {
        return materialComposition;
    }

    public CreateOfferDto setMaterialComposition(MaterialComposition materialComposition) {
        this.materialComposition = materialComposition;
        return this;
    }

    @Positive
    public BigDecimal getQuantity() {
        return quantity;
    }

    public CreateOfferDto setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public CreateOfferDto setDescription(String description) {
        this.description = description;
        return this;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public CreateOfferDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public CreateOfferDto setUrlImage(String urlImage) {
        this.urlImage = urlImage;
        return this;
    }
}
