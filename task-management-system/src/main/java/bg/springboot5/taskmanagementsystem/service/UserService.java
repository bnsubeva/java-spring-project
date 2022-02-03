package bg.springboot5.taskmanagementsystem.service;

import bg.springboot5.taskmanagementsystem.model.Task;
import bg.springboot5.taskmanagementsystem.model.User;

import java.util.List;

import org.springframework.data.domain.Page;

public  interface UserService {
    List<User> getAllUsers();

    User addUser(User user);

    User getUserById(Long userId);

    User updateUser(User user);

    void deleteUserById(Long userId);

}