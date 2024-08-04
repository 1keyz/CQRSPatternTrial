package com.example.cqrspatterntrial.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemCommand implements ICommand<Void>{
    private UUID productId;
    private UUID orderId;
    private double quantity;
}
