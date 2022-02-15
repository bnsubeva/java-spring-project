package com.spring.task.management.system.init;

import com.spring.task.management.system.entity.Team;
import com.spring.task.management.system.enums.Position;
import com.spring.task.management.system.entity.User;
import com.spring.task.management.system.repository.TeamRepository;
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
    private final TeamRepository teamRepository;

    @Autowired
    public DataInitializer(UserService userService, TeamRepository teamRepository) {
        this.userService = userService;
        this.teamRepository = teamRepository;
    }

    private final List<User> DEFAULT_USERS = Arrays.asList(
        new User("Erik", "erik1234", "erik@email.com", Position.PRODUCT_OWNER),
        new User("Bella", "bella1234", "bella_email2@email.com", Position.FRONTEND_DEVELOPER)
    );

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(userService.count() == 0) {
            log.info("Successfully created users: {}",
                DEFAULT_USERS.stream().map(userService::addUser).collect(Collectors.toList()));
            Team team = new Team("FMI Team", "Curious students");
            log.info("Successfully created team");
            teamRepository.save(new Team("FMI Team", "Curious students"));
        }
    }
}