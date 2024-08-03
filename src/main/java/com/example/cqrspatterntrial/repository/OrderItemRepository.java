package com.example.cqrspatterntrial.repository;

import com.example.cqrspatterntrial.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
}
