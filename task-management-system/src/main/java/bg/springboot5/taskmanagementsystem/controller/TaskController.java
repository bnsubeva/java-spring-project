package bg.springboot5.taskmanagementsystem.controller;

import bg.springboot5.taskmanagementsystem.model.Task;
import bg.springboot5.taskmanagementsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}