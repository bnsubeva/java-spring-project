package com.spring.task.management.system.service;

import com.spring.task.management.system.entity.Sprint;
import com.spring.task.management.system.entity.User;

import java.util.List;

public interface SprintService {

    List<Sprint> getAllSprints();

    Sprint findByName(String name);

    Sprint addSprint(Sprint sprint);

    long count();

}
