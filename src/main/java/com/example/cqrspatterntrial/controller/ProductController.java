package com.example.cqrspatterntrial.controller;

import com.example.cqrspatterntrial.command.CommandHandler;
import com.example.cqrspatterntrial.command.ProductCommandHandler;
import com.example.cqrspatterntrial.model.dto.CreateProductCommand;
import com.example.cqrspatterntrial.model.dto.GetProductByIdQuery;
import com.example.cqrspatterntrial.model.entity.Product;
import com.example.cqrspatterntrial.query.ProductQueryHandler;
import com.example.cqrspatterntrial.query.QueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public Product query(@RequestBody GetProductByIdQuery queryId) {
       return queryHandler.handle(queryId);
    }
}
