package com.example.cqrspatterntrial.controller;

import com.example.cqrspatterntrial.command.CommandHandler;
import com.example.cqrspatterntrial.command.ICommandBus;
import com.example.cqrspatterntrial.command.ProductCommand;
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
    private final ICommandBus iCommandBus;

    @PostMapping
    public void command(@RequestBody ProductCommand command) {
        iCommandBus.execute(command);
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
