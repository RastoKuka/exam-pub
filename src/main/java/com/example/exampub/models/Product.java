package com.example.exampub.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long productId;
    @Column(unique = true)
    private String productName;
    private int productPrice;
    private boolean isForAdult;
}
