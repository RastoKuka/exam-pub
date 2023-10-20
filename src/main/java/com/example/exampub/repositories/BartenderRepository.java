package com.example.exampub.repositories;

import com.example.exampub.models.Bartender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BartenderRepository extends JpaRepository<Bartender, Long> {
}
