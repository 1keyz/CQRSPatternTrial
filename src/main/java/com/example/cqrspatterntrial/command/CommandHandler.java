package com.example.cqrspatterntrial.command;

public interface CommandHandler <T>{
    void handle (T command);
}
