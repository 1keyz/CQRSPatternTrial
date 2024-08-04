package com.example.cqrspatterntrial.query;

import com.example.cqrspatterntrial.model.entity.ProductES;
import com.example.cqrspatterntrial.repository.ProductESRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductQueryHandler implements QueryHandler<ProductQuery, ProductES>{
    private final ProductESRepository esRepository;

    @Override
    public Stream<ProductES> handle(ProductQuery query) {
        Stream<ProductES> productES = esRepository.findById(query.getId()).stream();
        return productES;
    }

    @Override
    public Iterable<ProductES> getall() {
        Iterable<ProductES> list =  esRepository.findAll();
        return  list;
    }

    @Override
    public Stream<ProductES> getByName(String name) {
        return esRepository.getByName(name);
    }
}
