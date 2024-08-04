package com.example.cqrspatterntrial.query;

import com.example.cqrspatterntrial.command.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class QueryBusImpl implements IQueryBus{
    private final Set<QueryHandler> queryHandlers;


    @Override
    public <Q extends IQuery<R>, R> R execute(Q query) {
        QueryHandler<Q,R> queryHandler = (QueryHandler<Q, R>) findCommandHandler(query);
        return (R) queryHandler.handle(query);
    }
    private <T> QueryHandler<T, ?> findCommandHandler(T query) {
        Class<?> commandClazz = query.getClass();
        return queryHandlers.stream()
                .filter(handler -> canHandleQuery(handler.getClass(), commandClazz))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Do not handle " + commandClazz.getName()));
    }
    private boolean canHandleQuery(Class<?> handlerClazz, Class<?> commandClazz) {
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
