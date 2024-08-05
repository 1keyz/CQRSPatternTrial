package com.example.cqrspatterntrial.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCommand implements ICommand<Void>{
    private UUID id;
    private UUID userId;
    private List<OrderItemCommand> orderItems;
}
