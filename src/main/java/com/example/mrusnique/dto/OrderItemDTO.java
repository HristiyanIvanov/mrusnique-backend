package com.example.mrusnique.dto;

public class OrderItemDTO {
    private Long orderId;
    private Long variantId;
    private int quantity;
    private double price;

    public OrderItemDTO() {}

    public OrderItemDTO(Long orderId, Long variantId, int quantity, double price) {
        this.orderId = orderId;
        this.variantId = variantId;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getVariantId() {
        return variantId;
    }

    public void setVariantId(Long variantId) {
        this.variantId = variantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "orderId=" + orderId +
                ", variantId=" + variantId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
