package com.spring.task.management.system.controller;

import com.spring.task.management.system.model.User;
import com.spring.task.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User getUsers() {
        return User.builder().userName("Bella").userId(29393939L).build();
    }

}
