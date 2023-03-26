package com.example.demo.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
@Table(name = "musical_instruments")
public class MusicalInstrumentEntity extends BaseEntity{

    private String title;
    private String imageUrl;
    private BigDecimal instrumentPrice;

    public MusicalInstrumentEntity() {
    }
@Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public MusicalInstrumentEntity setTitle(String title) {
        this.title = title;
        return this;
    }
    @Column(nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public MusicalInstrumentEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
    @Column(nullable = false)

    public BigDecimal getInstrumentPrice() {
        return instrumentPrice;
    }

    public MusicalInstrumentEntity setInstrumentPrice(BigDecimal instrumentPrice) {
        this.instrumentPrice = instrumentPrice;
        return this;
    }
}
