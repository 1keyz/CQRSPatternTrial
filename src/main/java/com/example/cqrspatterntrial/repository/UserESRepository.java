package com.example.cqrspatterntrial.repository;

import com.example.cqrspatterntrial.model.entity.UserES;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public interface UserESRepository extends ElasticsearchRepository<UserES, UUID> {

    @Query("{\"wildcard\": {\"name\": \"*?0*\"}}")
    List<UserES> getByName(String name);
}
