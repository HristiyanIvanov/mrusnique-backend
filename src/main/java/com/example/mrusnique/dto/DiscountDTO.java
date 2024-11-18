package com.example.mrusnique.dto;

import java.time.LocalDateTime;

public class DiscountDTO {
    private Long productId;
    private String discountType;
    private double value;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public DiscountDTO() {}

    public DiscountDTO(Long productId, String discountType, double value, LocalDateTime startDate, LocalDateTime endDate) {
        this.productId = productId;
        this.discountType = discountType;
        this.value = value;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "DiscountDTO{" +
                "productId=" + productId +
                ", discountType='" + discountType + '\'' +
                ", value=" + value +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
