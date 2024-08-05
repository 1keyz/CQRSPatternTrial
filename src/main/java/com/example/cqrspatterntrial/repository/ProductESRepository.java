package com.example.cqrspatterntrial.repository;


import com.example.cqrspatterntrial.model.entity.ProductES;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface ProductESRepository extends ElasticsearchRepository<ProductES, UUID> {

    @Query("{\"match\": {\"name\": \"?0\"}}")
    List<ProductES> getByName(String name);
}
