package com.example.cqrspatterntrial.controller;

import com.example.cqrspatterntrial.command.ICommandBus;
import com.example.cqrspatterntrial.command.OrderCommand;
import com.example.cqrspatterntrial.command.OrderItemCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final ICommandBus commandBus;

    @PostMapping
    public void orderCommand(@RequestBody OrderCommand orderCommand) {
        commandBus.execute(orderCommand);
    }
}
