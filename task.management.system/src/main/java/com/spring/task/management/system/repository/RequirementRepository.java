package com.spring.task.management.system.repository;

import com.spring.task.management.system.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Long> {
}
