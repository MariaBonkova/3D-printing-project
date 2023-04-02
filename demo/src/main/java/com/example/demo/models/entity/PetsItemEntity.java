package com.example.demo.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pets_items")
public class PetsItemEntity extends BaseProduct{

    private String description;

    public PetsItemEntity() {
    }

    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public PetsItemEntity setDescription(String description) {
        this.description = description;
        return this;
    }

}
