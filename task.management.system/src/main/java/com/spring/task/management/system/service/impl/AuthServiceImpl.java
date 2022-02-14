package com.spring.task.management.system.service.impl;

import com.spring.task.management.system.entity.User;
import com.spring.task.management.system.service.AuthService;
import com.spring.task.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private final UserService userService;

    public AuthServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User login(String username, String password) {
        User user = userService.findByUsername(username);
        if(user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

}
