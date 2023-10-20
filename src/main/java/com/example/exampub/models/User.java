package com.example.exampub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long userId;
    @Column(unique = true)
    private String username;
    private String password;
    private boolean isActive;
    private boolean isAdult;
    private int pocket;

    @Enumerated(EnumType.STRING)
    private final Role role = Role.CUSTOMER;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Order> orders;
}
