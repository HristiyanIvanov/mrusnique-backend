package com.example.mrusnique.dto;

import java.math.BigDecimal;

public class ProductVariantDTO {
    private Long productId;
    private String size;
    private String color;
    private int stock;
    private BigDecimal additionalPrice;

    public ProductVariantDTO() {}

    public ProductVariantDTO(Long productId, String size, String color, int stock, BigDecimal additionalPrice) {
        this.productId = productId;
        this.size = size;
        this.color = color;
        this.stock = stock;
        this.additionalPrice = additionalPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(BigDecimal additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    @Override
    public String toString() {
        return "ProductVariantDTO{" +
                "productId=" + productId +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", stock=" + stock +
                ", additionalPrice=" + additionalPrice +
                '}';
    }
}
