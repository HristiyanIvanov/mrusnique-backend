package com.example.mrusnique.repository;

import com.example.mrusnique.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
