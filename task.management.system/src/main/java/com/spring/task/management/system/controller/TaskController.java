package com.spring.task.management.system.controller;

import com.spring.task.management.system.entity.Task;
import com.spring.task.management.system.entity.User;
import com.spring.task.management.system.repository.TaskRepository;
import com.spring.task.management.system.service.TaskService;
import com.spring.task.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/showNewTaskForm")
    public String showNewTaskForm(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "newTask";
    }

    @PostMapping("/showNewTaskForm")
    public String saveTask(@ModelAttribute("task") Task task, Authentication auth) {
        User user = userService.findByUsername(((User)auth.getPrincipal()).getUsername());
        taskService.addTask(task, user);
        System.out.println(task);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdateTask/{id}")
    public String showFormForUpdateTask(@PathVariable ( value = "id") long id, Model model) {

        Task task = taskService.getTaskById(id);

        model.addAttribute("task",task);
        return "updateTask";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable (value = "id") long id) {
        this.taskService.deleteTaskById(id);
        return "redirect:/";
    }

}
