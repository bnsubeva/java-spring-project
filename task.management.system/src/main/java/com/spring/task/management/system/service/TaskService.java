package com.spring.task.management.system.service;

import com.spring.task.management.system.entity.Task;

import java.util.List;

public  interface TaskService {
    List<Task> getAllTasks();

    Task addTask(Task task);

    Task getTaskById(Long taskId);

    Task getTaskByUserId(Long userId);

    Task updateTask(Task task);

    void deleteTaskById(Long taskId);
}
