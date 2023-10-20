package com.example.exampub.dto;

import com.example.exampub.models.Order;
import com.example.exampub.models.User;
import lombok.Data;

import java.util.List;

@Data
public class UserWithOrdersDTO {

    private Long userId;
    private String username;
    private boolean isActive;
    private boolean isAdult;
    private int pocket;
    private List<Order> orders;
    private UserService userService;

    public UserWithOrdersDTO(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.isActive = user.isActive();
        this.isAdult = user.isAdult();
        this.pocket = user.getPocket();
        this.orders = userService.getOrders(userId);
    }
}