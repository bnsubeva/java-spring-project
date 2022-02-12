package com.spring.task.management.system.service;

import com.spring.task.management.system.model.User;

public interface AuthService {
    User login(String username, String password);
}
