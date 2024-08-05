package com.example.cqrspatterntrial.query;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface QueryHandler <Q , R> {

    Optional<R> handle(Q query);

    Iterable<R> getAll();

    List<R> getByName(String name);
}
