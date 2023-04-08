package com.example.demo.models.entity;

import com.example.demo.models.entity.enums.MaterialComposition;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
@Table(name = "create_house_entity")
public class CreateHouseEntity extends BaseEntity {

    private String productName;
    private MaterialComposition materialComposition;
    private BigDecimal quadrature;
    private String description;
    private BigDecimal flat;
    private BigDecimal price;
    private String urlImage;

    public CreateHouseEntity() {
    }

    @Column(name = "product_name", nullable = false)
    public String getProductName() {
        return productName;
    }

    public CreateHouseEntity setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public MaterialComposition getMaterialComposition() {
        return materialComposition;
    }

    public CreateHouseEntity setMaterialComposition(MaterialComposition materialComposition) {
        this.materialComposition = materialComposition;
        return this;
    }

    @Column(name = "quadrature")
    public BigDecimal getQuadrature() {
        return quadrature;
    }

    public CreateHouseEntity setQuadrature(BigDecimal quadrature) {
        this.quadrature = quadrature;
        return this;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public CreateHouseEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column
    public BigDecimal getFlat() {
        return flat;
    }

    public CreateHouseEntity setFlat(BigDecimal flat) {
        this.flat = flat;
        return this;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public CreateHouseEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public CreateHouseEntity setUrlImage(String urlImage) {
        this.urlImage = urlImage;
        return this;
    }
}
