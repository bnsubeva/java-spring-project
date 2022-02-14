package com.spring.task.management.system.repository;

import com.spring.task.management.system.entity.TaskResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskResultRepository extends JpaRepository<TaskResult, Long> {
}
