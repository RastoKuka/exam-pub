package com.example.exampub.dto;

import com.example.exampub.models.Order;
import com.example.exampub.services.UserService;
import lombok.Data;

import java.util.List;

@Data
public class UserWithOrdersDto {


    private Long userId;
    private String username;
    private boolean isActive;
    private boolean isAdult;
    private int pocket;
    private List<Order> orders;
    private UserService userService;

    public UserWithOrdersDto(Long userId, String username, boolean isActive, boolean isAdult,
                             int pocket, List<Order> orders) {
        this.userId = userId;
        this.username = username;
        this.isActive = isActive;
        this.isAdult = isAdult;
        this.pocket = pocket;
        this.orders = orders;
    }
}
