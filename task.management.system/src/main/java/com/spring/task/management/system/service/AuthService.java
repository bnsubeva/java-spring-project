package com.spring.task.management.system.service;

import com.spring.task.management.system.entity.User;

public interface AuthService {
    User login(String username, String password);
}
