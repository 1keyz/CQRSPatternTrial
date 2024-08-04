package com.example.cqrspatterntrial.controller;

import com.example.cqrspatterntrial.command.CommandBusImpl;
import com.example.cqrspatterntrial.command.ICommandBus;
import com.example.cqrspatterntrial.command.OrderItemCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-item")
@RequiredArgsConstructor
public class OrderItemController {
    private final ICommandBus commandBus;

    @PostMapping
    public void orderCommand(OrderItemCommand orderItemCommand) {
        commandBus.execute(orderItemCommand);
    }
}
