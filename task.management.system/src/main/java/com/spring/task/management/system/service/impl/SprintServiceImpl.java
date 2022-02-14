package com.spring.task.management.system.service.impl;

import com.spring.task.management.system.entity.Sprint;
import com.spring.task.management.system.exception.EntityNotFoundException;
import com.spring.task.management.system.repository.SprintRepository;
import com.spring.task.management.system.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class SprintServiceImpl implements SprintService {

    private final SprintRepository sprintRepository;

    @Autowired
    public SprintServiceImpl(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sprint> getAllSprints() { return sprintRepository.findAll(); }

    @Override
    public Sprint findByName(String name) {
        return sprintRepository.findBySprintName(name).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Sprint addSprint(Sprint Sprint) {
        return new Sprint();
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return sprintRepository.count();
    }

}
