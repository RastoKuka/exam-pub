package com.example.exampub.controllers;

import com.example.exampub.dto.UserWithOrdersDTO;
import com.example.exampub.models.Order;
import com.example.exampub.models.Product;
import com.example.exampub.models.User;
import com.example.exampub.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.exampub.services.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {


    private final UserService userService;
    private final ProductService productService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> maybeUser = userService.getUserById(id);
        if (maybeUser.isPresent()) {
            return ResponseEntity.status(200).body(new UserWithOrdersDTO(maybeUser.get()));
        } else {
            return ResponseEntity.status(404).body("User does not exist.");
        }
    }

    @GetMapping("/drink-menu")
    public ResponseEntity<?> showMenu() {
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @PostMapping("/buy")
    public ResponseEntity<?> TryToBuy(@RequestParam("drink")Optional<Product> drinkName, @RequestParam("amount") int amount){
        User user = User.builder()
                .userId(userService.getCurrentUserId())
                .username(userService.getCurrentUserName())
                .isActive(userService.getCurrentUserStatus())
                .isAdult(userService.getCurrentUserAgeLimit()).
                pocket(userService.getCurrentUserMoneyStatus()).
                build();

        if (user.getPocket() <= amount * productService.getProductPrice(drinkName.toString())) {
            return ResponseEntity.status(402).body("You can't afford this!");
        } else if (!user.isAdult() && productService.isForAdult(drinkName.toString())) {
            return ResponseEntity.status(400).body("Be back, when you'll grow up!");
        } else if (!user.isAdult() && !productService.isForAdult(drinkName.toString()) && user.getPocket() >=
                productService.getProductPrice(drinkName.toString())) {
            Order order = new Order(user, drinkName.get(), amount);
            userService.payingForIt(order.getPrice(), user.getUserId());
            return ResponseEntity.status(201).body("Time to pay!" + order);
        } else if (user.isAdult() && user.getPocket() >= amount * productService.getProductPrice(drinkName.toString())){
            Order order = new Order(user, drinkName.get(), amount);
            userService.payingForIt(order.getPrice(), user.getUserId());
            return ResponseEntity.status(201).body("Time to pay!" + order);
        } else {
            return  ResponseEntity.status(417).body("You're trying wrong door...!");
        }

    }

    /*
    @GetMapping("/summary/all")
    public ResponseEntity<?> getAllOrdersOfAllDrinks(){
        //return DTO that contains  product, amount, unitprice summarz price / kinda like inventorz linsting


    }

    @GetMapping("/summary/product")
    public ResponseEntity<?> getAllOrdersOfThisProduct(@RequestParam Optional<String> productName){
        //return DTO that contains  all orders of this drink for all drinks like in a table?


    }

    @GetMapping("/summary/user")
    public ResponseEntity<?> getAllOrdersOfUser(@RequestParam Optional<String> username){
        //return DTO that contains  all orders of this user
        //or returns DTO that contains all orders of user and displazs it for all users

    }

*/
}
