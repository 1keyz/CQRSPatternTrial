package com.example.cqrspatterntrial.query;

import com.example.cqrspatterntrial.command.ICommand;

public interface IQueryBus {
    <Q extends IQuery<R>, R> R execute(Q query);
}
