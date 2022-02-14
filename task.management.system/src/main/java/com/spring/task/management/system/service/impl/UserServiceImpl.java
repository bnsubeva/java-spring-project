package com.spring.task.management.system.service.impl;

import com.spring.task.management.system.entity.User;
import com.spring.task.management.system.exception.EntityNotFoundException;
import com.spring.task.management.system.repository.UserRepository;
import com.spring.task.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() { return userRepository.findAll(); }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
            () -> new EntityNotFoundException("User with such username " + username + " doesn't exist!")
        );
    }

    @Override
    public User addUser(User user) {
        user.setUserId(null);
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setActive(true);
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return userRepository.count();
    }
}

