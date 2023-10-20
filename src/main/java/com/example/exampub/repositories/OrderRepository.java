package com.example.exampub.repositories;

import com.example.exampub.models.Order;
import com.example.exampub.models.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface OrderRepository extends ListCrudRepository<Order, Long> {
    List<Order> findAllByUser(User user);
}
