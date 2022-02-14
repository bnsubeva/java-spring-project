package com.spring.task.management.system.init;

import com.spring.task.management.system.enums.Position;
import com.spring.task.management.system.entity.User;
import com.spring.task.management.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class DataInitializer implements ApplicationRunner {

    private final UserService userService;

    @Autowired
    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    private final List<User> DEFAULT_USERS = Arrays.asList(
        new User("admin", "Admin123&", "admin_email1@email.com", Position.BACKEND_DEVELOPER),
        new User("author", "Author123&", "admin_email2@email.com", Position.BACKEND_DEVELOPER)
    );

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("SOMETJHING");
        System.out.println(userService.count());
        if(userService.count() == 0) {
            log.info("Successfully created users: {}",
                DEFAULT_USERS.stream().map(userService::addUser).collect(Collectors.toList()));
        }
    }
}