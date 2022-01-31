package bg.springboot5.taskmanagementsystem.controller;

import bg.springboot5.taskmanagementsystem.model.User;
import bg.springboot5.taskmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
