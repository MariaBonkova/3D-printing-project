package com.example.demo.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
@Table(name = "musical_instruments")
public class MusicalInstrumentEntity extends BaseProduct{

    private String description;

    public MusicalInstrumentEntity() {
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public MusicalInstrumentEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
