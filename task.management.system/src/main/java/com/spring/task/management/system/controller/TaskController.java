package com.spring.task.management.system.controller;

import com.spring.task.management.system.entity.Task;
import com.spring.task.management.system.repository.TaskRepository;
import com.spring.task.management.system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    public Task addTask( @RequestBody Task task){
        return taskService.addTask(task);
    }


    @GetMapping("/showNewTaskForm")
    public String showNewTaskForm(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        System.out.println("asd");
        return "newTask";
    }
    @PostMapping("/showNewTaskForm")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.addTask(task);
        Task task2=taskService.addTask(task);
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
