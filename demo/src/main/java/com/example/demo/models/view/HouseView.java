package com.example.demo.models.view;

import java.math.BigDecimal;

public class HouseView {

    private Long id;
    private String productName;
    private BigDecimal price;
    private String urlImage;

    public HouseView(Long id, String productName, BigDecimal price, String urlImage) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.urlImage = urlImage;
    }

    public Long getId() {
        return id;
    }

    public HouseView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public HouseView setProductName(String productName) {
        this.productName = productName;
        return this;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public HouseView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public HouseView setUrlImage(String urlImage) {
        this.urlImage = urlImage;
        return this;
    }
}
