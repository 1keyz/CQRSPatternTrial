package com.example.cqrspatterntrial.repository;

import com.example.cqrspatterntrial.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
