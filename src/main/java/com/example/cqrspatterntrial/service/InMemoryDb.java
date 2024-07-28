package com.example.cqrspatterntrial.service;

import com.example.cqrspatterntrial.model.entity.Product;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;



@Component
public class InMemoryDb {
    Map<Integer, Product> inMemory = new HashMap<>();

    public void save(Product product) {
        Integer id = 0;
        id++;
        inMemory.put(id,product);
    }

    public Product getById(Integer id) {
       return inMemory.get(id);
    }
}
