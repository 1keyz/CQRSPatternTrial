package com.example.cqrspatterntrial.controller;

import com.example.cqrspatterntrial.command.ICommandBus;
import com.example.cqrspatterntrial.command.UserCommand;
import com.example.cqrspatterntrial.model.entity.UserES;
import com.example.cqrspatterntrial.query.IQueryBus;
import com.example.cqrspatterntrial.query.UserQuery;
import com.example.cqrspatterntrial.query.UserQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final ICommandBus commandBus;
    private final UserQueryHandler queryHandler;
    private final IQueryBus queryBus;
    @PostMapping
    public void userCommand(@RequestBody UserCommand userCommand) {
        commandBus.<UserCommand, Void>execute(userCommand);
    }
    @GetMapping("/get")
    public Optional<UserES> query(@RequestParam UUID userId) {
        return queryHandler.handle(new UserQuery(userId));
    }

    @GetMapping("/getAll")
    public Iterable<UserES> getAll() {
        return queryHandler.getAll();
    }

    @GetMapping("/getByName")
    public List<UserES> getByName(@RequestParam String name) {
        return queryHandler.getByName(name);
    }

}
