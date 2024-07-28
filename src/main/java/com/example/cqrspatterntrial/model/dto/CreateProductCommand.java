package com.example.cqrspatterntrial.model.dto;

import lombok.Getter;

@Getter
public class CreateProductCommand {
    private String name;
    private double price;
}
