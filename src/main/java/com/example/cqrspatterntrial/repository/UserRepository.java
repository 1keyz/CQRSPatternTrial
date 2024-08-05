package com.example.cqrspatterntrial.repository;

import com.example.cqrspatterntrial.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
