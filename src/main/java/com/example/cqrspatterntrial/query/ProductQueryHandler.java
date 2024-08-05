package com.example.cqrspatterntrial.query;

import com.example.cqrspatterntrial.model.entity.ProductES;
import com.example.cqrspatterntrial.repository.ProductESRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductQueryHandler implements QueryHandler<ProductQuery, ProductES>{
    private final ProductESRepository esRepository;

    @Override
    public Optional<ProductES> handle(ProductQuery query) {
        Optional<ProductES> productES = esRepository.findById(query.getId());
        return productES;
    }

    @Override
    public Iterable<ProductES> getAll() {
        Iterable<ProductES> list =  esRepository.findAll();
        return  list;
    }

    @Override
    public List<ProductES> getByName(String name) {
        return esRepository.getByName(name);
    }
}
