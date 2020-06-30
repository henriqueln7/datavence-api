package com.datavenceapi.controllers;

import com.datavenceapi.models.User;
import com.datavenceapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> index() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<User> save(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }
}
