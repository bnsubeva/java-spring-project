package com.spring.task.management.system.service.impl;

import com.spring.task.management.system.entity.Product;
import com.spring.task.management.system.entity.Sprint;
import com.spring.task.management.system.entity.Task;
import com.spring.task.management.system.entity.User;
import com.spring.task.management.system.repository.TaskRepository;
import com.spring.task.management.system.service.ProductService;
import com.spring.task.management.system.service.SprintService;
import com.spring.task.management.system.service.TaskService;
import com.spring.task.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProductService productService;
    private final UserService userService;
    private final SprintService sprintService;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, ProductService productService, UserService userService,
                           SprintService sprintService) {
        this.taskRepository = taskRepository;
        this.productService = productService;
        this.userService = userService;
        this.sprintService = sprintService;
    }

    @Override
    public List<Task> getAllTasks() { return taskRepository.findAll(); }

    @Override
    public Task addTask(Task task, User assignedFrom) {
        Product product = productService.findByName(task.getProductName());
        User assignedTo = userService.findByUsername(task.getAssignedToName());
        Sprint sprint = sprintService.findByName(task.getSprintName());
        task.setProduct(product);
        task.setAssignedTo(assignedTo);
        task.setSprint(sprint);
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long taskId) {return taskRepository.findById(taskId).get();}

    @Override
    public Task getTaskByUserId(Long userId) {return taskRepository.findById(userId).get();}

    @Override
    public Task updateTask(Task task) {return taskRepository.save(task);}

    @Override
    public void deleteTaskById(Long taskId) {taskRepository.deleteById(taskId);}
}
