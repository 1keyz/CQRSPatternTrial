package com.example.cqrspatterntrial.repository;

import com.example.cqrspatterntrial.model.entity.OrderES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.UUID;

public interface OrderESRepository extends ElasticsearchRepository<OrderES, UUID> {
}
