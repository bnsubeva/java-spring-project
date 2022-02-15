package com.spring.task.management.system.repository;

import com.spring.task.management.system.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
