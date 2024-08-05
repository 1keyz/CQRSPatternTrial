package com.example.cqrspatterntrial.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserQuery implements IQuery{
    private UUID id;
}
