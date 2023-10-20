package com.example.exampub.services;

import com.example.exampub.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessionService {

    private final UserRepository userRepository;
}
