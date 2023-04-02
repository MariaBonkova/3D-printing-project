package com.example.demo.models.view;

import java.math.BigDecimal;

public class PetsView {

    private Long id;
    private String productName;
    private BigDecimal price;
    private String urlImage;

    public PetsView() {
    }

    public PetsView(Long id, String productName, BigDecimal price, String urlImage) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.urlImage = urlImage;
    }

    public Long getId() {
        return id;
    }

    public PetsView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public PetsView setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PetsView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public PetsView setUrlImage(String urlImage) {
        this.urlImage = urlImage;
        return this;
    }
}