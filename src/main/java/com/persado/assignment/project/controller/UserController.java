package com.persado.assignment.project.controller;

import com.persado.assignment.project.model.User;
import com.persado.assignment.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookshop")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "users/")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }


    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUser(id);
        return ResponseEntity
                .ok()
                .body(user);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(null);
    }

    @GetMapping(value = "/users/")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity
                .ok()
                .body(userService.getUsers());
    }
}
