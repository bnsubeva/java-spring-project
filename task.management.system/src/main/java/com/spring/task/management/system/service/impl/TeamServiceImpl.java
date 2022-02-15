package com.spring.task.management.system.service.impl;

import com.spring.task.management.system.entity.Team;
import com.spring.task.management.system.repository.TeamRepository;
import com.spring.task.management.system.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAllTeams() { return teamRepository.findAll(); }
}
