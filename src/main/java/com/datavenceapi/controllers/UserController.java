package com.datavenceapi.controllers;

import com.datavenceapi.models.User;
import com.datavenceapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> index() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<User> save(@RequestBody @Valid User user) {
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
