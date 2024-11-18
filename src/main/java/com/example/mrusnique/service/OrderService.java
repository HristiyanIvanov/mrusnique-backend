package com.example.mrusnique.service;

import com.example.mrusnique.dto.OrderDTO;
import com.example.mrusnique.model.Order;
import com.example.mrusnique.model.User;
import com.example.mrusnique.repository.OrderRepository;
import com.example.mrusnique.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();

        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        order.setUser(user);

        order.setTotalAmount(BigDecimal.valueOf(orderDTO.getTotalAmount()));
        order.setOrderStatus(orderDTO.getOrderStatus());

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public Order updateOrder(Long orderId, OrderDTO orderDTO) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));


        order.setTotalAmount(BigDecimal.valueOf(orderDTO.getTotalAmount()));
        order.setOrderStatus(orderDTO.getOrderStatus());

        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        order.setUser(user);

        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
