package com.example.cqrspatterntrial.command;

import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Set;

import java.util.Map;

@Component
public class CommandBusImpl implements ICommandBus {
    private final Map<Class<? extends ICommand>,CommandHandler<ICommand, ?>> commandHandlers = new HashMap<>();

    public CommandBusImpl(Set<CommandHandler> commandHandlerBeans) {
        commandHandlerBeans.stream().forEach(commandHandler -> {
            Class<? extends ICommand> commandClass = getCommandClass(commandHandler.getClass());
            commandHandlers.put(commandClass, commandHandler);
        });
    }

    @Override
    public <C extends ICommand<R>, R> R execute(C command) {
        CommandHandler<C, R> handler = (CommandHandler<C, R>) findCommandHandler(command);
        return handler.handle(command);
    }


    private <C> CommandHandler<C, ?> findCommandHandler(C command) {
        return (CommandHandler<C, ?>) commandHandlers.get(command.getClass());
    }

    private Class<? extends ICommand> getCommandClass(Class<?> handlerClazz) {
        Type[] genericInterfaces = handlerClazz.getGenericInterfaces();
        ParameterizedType handlerIntefaceType = null;

        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                handlerIntefaceType = (ParameterizedType) type;
                break;
            }
        }

        Class<? extends ICommand> acceptableParameterClass = (Class<? extends ICommand>) handlerIntefaceType.getActualTypeArguments()[0];
        return acceptableParameterClass;
    }

}