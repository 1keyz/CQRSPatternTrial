package com.example.cqrspatterntrial.query;

import com.example.cqrspatterntrial.model.entity.Product;
import com.example.cqrspatterntrial.model.entity.ProductES;

import java.util.List;
import java.util.stream.Stream;

public interface QueryHandler <T , V> {

    Stream<V> handle(T query);

    Iterable<V> getall();
}
