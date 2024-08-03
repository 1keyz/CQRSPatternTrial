package com.example.cqrspatterntrial.repository;

import com.example.cqrspatterntrial.model.entity.OrderItemES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.UUID;

public interface OrderItemESRepository extends ElasticsearchRepository<OrderItemES, UUID> {
}
