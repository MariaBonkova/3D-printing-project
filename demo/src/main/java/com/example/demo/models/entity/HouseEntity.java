package com.example.demo.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "house")
public class HouseEntity extends BaseProduct{

    private BigDecimal quadrature;
    private String description;

    public HouseEntity() {
    }

    @Column(nullable = false)
    public BigDecimal getQuadrature() {
        return quadrature;
    }

    public HouseEntity setQuadrature(BigDecimal quadrature) {
        this.quadrature = quadrature;
        return this;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public HouseEntity setDescription(String description) {
        this.description = description;
        return this;
    }




}
