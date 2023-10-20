package com.example.exampub.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private Long productId;
    @Column(unique = true)
    private String productName;
    private int productPrice;
    private boolean isForAdult;
    private int amountSold;
}
