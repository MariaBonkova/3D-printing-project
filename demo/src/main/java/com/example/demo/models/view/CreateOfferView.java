package com.example.demo.models.view;

import java.math.BigDecimal;

public class CreateOfferView {

    private Long id;
    private String productName;
    private BigDecimal price;
    private String urlImage;

    public CreateOfferView() {
    }

    public CreateOfferView(Long id, String productName, BigDecimal price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public CreateOfferView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public CreateOfferView setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CreateOfferView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public CreateOfferView setUrlImage(String urlImage) {
        this.urlImage = urlImage;
        return this;
    }
}