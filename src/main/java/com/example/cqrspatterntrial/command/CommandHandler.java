package com.example.cqrspatterntrial.command;

public interface CommandHandler <C,R>{
    R handle (C command);
}
