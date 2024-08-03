package com.example.cqrspatterntrial.query;

import com.example.cqrspatterntrial.model.dto.GetProductByIdQuery;
import com.example.cqrspatterntrial.model.entity.Product;
import com.example.cqrspatterntrial.model.entity.ProductES;
import com.example.cqrspatterntrial.repository.ProductESRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductQueryHandler implements QueryHandler<GetProductByIdQuery, ProductES>{
    private final ProductESRepository esRepository;

    @Override
    public Stream<ProductES> handle(GetProductByIdQuery query) {
        Stream<ProductES> productES =  esRepository.getByName(query.getId());
        return productES;
    }

    @Override
    public Iterable<ProductES> getall() {
        Iterable<ProductES> list =  esRepository.findAll();
        return  list;
    }
}
