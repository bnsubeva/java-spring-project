package com.spring.task.management.system.repository;

import com.spring.task.management.system.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {
}
