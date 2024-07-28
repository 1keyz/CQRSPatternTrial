package com.example.cqrspatterntrial.query;

import com.example.cqrspatterntrial.model.entity.Product;

public interface QueryHandler <T , V> {

    V handle(T query);
}
