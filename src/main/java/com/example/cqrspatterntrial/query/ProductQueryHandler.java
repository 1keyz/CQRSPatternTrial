package com.example.cqrspatterntrial.query;

import com.example.cqrspatterntrial.model.dto.GetProductByIdQuery;
import com.example.cqrspatterntrial.model.entity.Product;
import com.example.cqrspatterntrial.repository.ProductRepository;
import com.example.cqrspatterntrial.service.InMemoryDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductQueryHandler implements QueryHandler<GetProductByIdQuery, Product>{
    private final InMemoryDb db;

    @Override
    public Product handle(GetProductByIdQuery query) {
        return db.getById(query.getId());
    }
}
