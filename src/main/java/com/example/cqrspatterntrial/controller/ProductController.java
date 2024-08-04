package com.example.cqrspatterntrial.controller;

import com.example.cqrspatterntrial.command.ICommandBus;
import com.example.cqrspatterntrial.command.ProductCommand;
import com.example.cqrspatterntrial.command.ProductCommandHandler;

import com.example.cqrspatterntrial.model.entity.ProductES;
import com.example.cqrspatterntrial.model.entity.dto;
import com.example.cqrspatterntrial.query.IQueryBus;
import com.example.cqrspatterntrial.query.ProductQuery;
import com.example.cqrspatterntrial.query.ProductQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Stream;

@RestController
@RequestMapping("/prod")
@RequiredArgsConstructor
public class ProductController {
    private final ProductCommandHandler commandHandler;
    private final ProductQueryHandler queryHandler;
    private final ICommandBus iCommandBus;
    private final IQueryBus queryBus;

    @PostMapping
    public void command(@RequestBody ProductCommand command) {
        iCommandBus.execute(command);
    }

    @GetMapping
    public void query(@RequestBody ProductQuery query) {
        queryBus.execute(query);
    }

    @GetMapping("/getAll")
    public Stream<ProductES> getall(@RequestBody dto dto) {
        return queryHandler.getByName(dto.getString());
    }
}
