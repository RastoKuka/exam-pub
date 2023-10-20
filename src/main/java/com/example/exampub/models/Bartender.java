package com.example.exampub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bartenders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bartender {

    @Id
    @GeneratedValue
    private Long bartenderId;
    private String bartenderName;
    private String password;
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    private Role role = Role.BARTENDER;
}
