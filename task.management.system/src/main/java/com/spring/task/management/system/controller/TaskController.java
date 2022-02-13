package com.spring.task.management.system.controller;

import com.spring.task.management.system.model.Task;
import com.spring.task.management.system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public Task getTasks() {
        return Task.builder().taskName("Task").taskId(29393939L).build();
    }

    @PostMapping
    public Task addTask( @RequestBody Task task){
        return taskService.addTask(task);
    }

}
