package com.example.cqrspatterntrial.query;

import com.example.cqrspatterntrial.model.entity.Product;
import com.example.cqrspatterntrial.model.entity.ProductES;

import java.util.List;
import java.util.stream.Stream;

public interface QueryHandler <Q , R> {

    Stream<R> handle(Q query);

    Iterable<R> getall();

    Stream<R> getByName(String name);
}
