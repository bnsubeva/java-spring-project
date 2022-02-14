package com.spring.task.management.system.service.impl;

import com.spring.task.management.system.entity.Sprint;
import com.spring.task.management.system.entity.SprintResult;
import com.spring.task.management.system.exception.EntityNotFoundException;
import com.spring.task.management.system.repository.SprintRepository;
import com.spring.task.management.system.repository.SprintResultRepository;
import com.spring.task.management.system.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SprintServiceImpl implements SprintService {

    private final SprintRepository sprintRepository;
    private final SprintResultRepository sprintResultRepository;

    @Autowired
    public SprintServiceImpl(SprintRepository sprintRepository, SprintResultRepository sprintResultRepository) {
        this.sprintRepository = sprintRepository;
        this.sprintResultRepository = sprintResultRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sprint> getAllSprints() { return sprintRepository.findAll(); }

    @Override
    @Transactional(readOnly = true)
    public Sprint findByName(String name) {
        return sprintRepository.findBySprintName(name).orElseThrow(
            () -> new EntityNotFoundException("Sprint with such name " + name + " doesn't exist!")
        );
    }

    @Override
    public Sprint addSprint(Sprint sprint) {
        SprintResult sprintResult = new SprintResult();
        SprintResult created = sprintResultRepository.save(sprintResult);
        sprint.setSprintResult(created);
        return sprintRepository.save(sprint);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return sprintRepository.count();
    }

}
