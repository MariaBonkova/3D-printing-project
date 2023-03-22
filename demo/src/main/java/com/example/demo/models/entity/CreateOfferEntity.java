package com.example.demo.models.entity;

import com.example.demo.models.entity.enums.MaterialComposition;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "create_offer_entity")
public class CreateOfferEntity extends BaseEntity {

    private String productName;
    private MaterialComposition materialComposition;
    private BigDecimal quantity;
    private String description;
    private BigDecimal price;

    public CreateOfferEntity() {
    }

    @Column(name = "product_name", nullable = false)
    public String getProductName() {
        return productName;
    }

    public CreateOfferEntity setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    @Column(nullable = false)
    public MaterialComposition getMaterialComposition() {
        return materialComposition;
    }

    public CreateOfferEntity setMaterialComposition(MaterialComposition materialComposition) {
        this.materialComposition = materialComposition;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getQuantity() {
        return quantity;
    }

    public CreateOfferEntity setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public CreateOfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public CreateOfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
