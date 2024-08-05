package com.example.cqrspatterntrial.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand implements ICommand<Void>{
    private UUID id;
    private String name;
}
