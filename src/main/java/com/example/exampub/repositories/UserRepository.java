package com.example.exampub.repositories;

import com.example.exampub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository {

    Optional<User> findUserByUsername (String username);
}
