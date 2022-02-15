package com.spring.task.management.system.repository;

import com.spring.task.management.system.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
