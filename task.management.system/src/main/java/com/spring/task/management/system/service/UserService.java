package com.spring.task.management.system.service;


import com.spring.task.management.system.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getByUsername(String username);

    User addUser(User user);

    User login(Long userId);

    User updateUser(User user);

    void deleteUserById(Long userId);

}
