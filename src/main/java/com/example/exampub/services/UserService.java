package com.example.exampub.services;

import com.example.exampub.models.Order;
import com.example.exampub.models.User;
import com.example.exampub.repositories.UserRepository;
import com.example.exampub.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Order> getOrders(Long id) {
        return orderRepository.findAllByUser((User) userRepository.findById(id).get());
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return userRepository.findUserByUsername(name).get().getUserId();
    }

    public String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public boolean getCurrentUserStatus() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return userRepository.findUserByUsername(name).get().isActive();
    }

    public boolean getCurrentUserAgeLimit() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return userRepository.findUserByUsername(name).get().isAdult();
    }

    public int getCurrentUserMoneyStatus() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return userRepository.findUserByUsername(name).get().getPocket();
    }

    public void payingForIt(int price, Long userId) {
        User user = (User) userRepository.findById(userId).get();
        user.setPocket(user.getPocket() - price);
    }
}
