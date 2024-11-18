package com.example.mrusnique.service;

import com.example.mrusnique.dto.OrderItemDTO;
import com.example.mrusnique.model.Order;
import com.example.mrusnique.model.OrderItem;
import com.example.mrusnique.model.ProductVariant;
import com.example.mrusnique.repository.OrderItemRepository;
import com.example.mrusnique.repository.OrderRepository;
import com.example.mrusnique.repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductVariantRepository productVariantRepository;

    public OrderItem createOrderItem(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();

        Order order = orderRepository.findById(orderItemDTO.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderItem.setOrder(order);

        ProductVariant productVariant = productVariantRepository.findById(orderItemDTO.getVariantId())
                .orElseThrow(() -> new RuntimeException("Product Variant not found"));
        orderItem.setProductVariant(productVariant);

        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setPrice(BigDecimal.valueOf(orderItemDTO.getPrice()));

        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(Long orderItemId) {
        return orderItemRepository.findById(orderItemId);
    }

    public OrderItem updateOrderItem(Long orderItemId, OrderItemDTO orderItemDTO) {
        OrderItem orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));

        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setPrice(BigDecimal.valueOf(orderItemDTO.getPrice()));

        Order order = orderRepository.findById(orderItemDTO.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderItem.setOrder(order);

        ProductVariant productVariant = productVariantRepository.findById(orderItemDTO.getVariantId())
                .orElseThrow(() -> new RuntimeException("Product Variant not found"));
        orderItem.setProductVariant(productVariant);

        return orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
}
