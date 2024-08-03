package com.example.cqrspatterntrial.controller;

import com.example.cqrspatterntrial.command.CommandHandler;
import com.example.cqrspatterntrial.command.ProductCommandHandler;
import com.example.cqrspatterntrial.model.dto.CreateProductCommand;
import com.example.cqrspatterntrial.model.dto.GetProductByIdQuery;
import com.example.cqrspatterntrial.model.entity.Product;
import com.example.cqrspatterntrial.model.entity.ProductES;
import com.example.cqrspatterntrial.query.ProductQueryHandler;
import com.example.cqrspatterntrial.query.QueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/prod")
@RequiredArgsConstructor
public class ProductController {
    private final ProductCommandHandler commandHandler;
    private final ProductQueryHandler queryHandler;

    @PostMapping
    public void command(@RequestBody CreateProductCommand command) {
        commandHandler.handle(command);
    }

    @GetMapping
    public Stream<ProductES> query(@RequestBody GetProductByIdQuery queryId) {
       return queryHandler.handle(queryId);
    }

    @GetMapping("/getAll")
    public Iterable<ProductES> getall() {
        return queryHandler.getall();
    }
}
