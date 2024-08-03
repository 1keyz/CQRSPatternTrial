package com.example.cqrspatterntrial.command;

public interface ICommandBus {
    <C> CommandHandler<C, Void> execute(C command);

    <C extends ICommand<R>, R> R execute(C command);
}
