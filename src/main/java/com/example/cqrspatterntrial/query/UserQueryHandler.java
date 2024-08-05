package com.example.cqrspatterntrial.query;

import com.example.cqrspatterntrial.model.entity.UserES;
import com.example.cqrspatterntrial.repository.UserESRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
@Service
@RequiredArgsConstructor
public class UserQueryHandler implements QueryHandler<UserQuery, UserES>{
    private final UserESRepository esRepository;
    @Override
    public Optional<UserES> handle(UserQuery query) {
        return esRepository.findById(query.getId());

    }

    @Override
    public Iterable<UserES> getAll() {
        return esRepository.findAll();
    }

    @Override
    public List<UserES> getByName(String name) {
        return esRepository.getByName(name);
    }
}
