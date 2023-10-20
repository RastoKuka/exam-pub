package com.example.exampub.repositories;

import com.example.exampub.models.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ProductRepository extends ListCrudRepository<Product, Long> {
    Optional<Product> findProductByProductName(String productName);
}
