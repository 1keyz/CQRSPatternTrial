package com.example.cqrspatterntrial.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CommandBusImpl implements ICommandBus {
    private final Set<CommandHandler> commandHandlers;
    @Override
    public <C extends ICommand<R>, R> R execute(C command) {
        CommandHandler<C, R> handler = (CommandHandler<C, R>) findCommandHandler(command);
        return handler.handle(command);
    }


    private <C> CommandHandler<C, ?> findCommandHandler(C command) {
        Class<?> commandClazz = command.getClass();
        return  commandHandlers.stream()
                .filter(handler -> canHandleCommand(handler.getClass(), commandClazz))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Do not handle " + commandClazz.getName()));
    }
    private boolean canHandleCommand(Class<?> handlerClazz, Class<?> commandClazz) {
        Type[] genericInterfaces = handlerClazz.getGenericInterfaces();
        ParameterizedType handlerIntefaceType = null;

        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                handlerIntefaceType = (ParameterizedType) type;
                break;
            }
        }

        Class<?> acceptableParameterClass = (Class<?>) handlerIntefaceType.getActualTypeArguments()[0];
        return acceptableParameterClass.equals(commandClazz);
    }
}
