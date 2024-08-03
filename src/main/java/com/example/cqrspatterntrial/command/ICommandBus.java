package com.example.cqrspatterntrial.command;

public interface ICommandBus {


    <C extends ICommand<R>, R> R execute(C command);
}
