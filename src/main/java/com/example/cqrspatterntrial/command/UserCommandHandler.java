package com.example.cqrspatterntrial.command;

import com.example.cqrspatterntrial.kafka.ProducerService;
import com.example.cqrspatterntrial.model.entity.UserES;
import com.example.cqrspatterntrial.model.entity.User;
import com.example.cqrspatterntrial.repository.UserESRepository;
import com.example.cqrspatterntrial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserCommandHandler implements CommandHandler<UserCommand, Void>{
    private final UserRepository userRepository;
    private final UserESRepository userESRepository;
    private final ProducerService producerService;
    @Override
    public Void handle(UserCommand command) {
        User user = User.builder()
                .id(UUID.randomUUID())
                .name(command.getName())
                .build();
        userRepository.save(user);
        producerService.producer(user);
        UserES userES = new UserES();
        userES.setId(user.getId());
        userES.setName(user.getName());
        userESRepository.save(userES);
        return null;
    }
}
