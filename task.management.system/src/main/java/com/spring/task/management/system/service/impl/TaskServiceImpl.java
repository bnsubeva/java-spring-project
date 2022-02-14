package com.spring.task.management.system.service.impl;

import com.spring.task.management.system.entity.*;
import com.spring.task.management.system.repository.TaskRepository;
import com.spring.task.management.system.repository.TaskResultRepository;
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
    private final TaskResultRepository taskResultRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, ProductService productService, UserService userService,
                           SprintService sprintService, TaskResultRepository taskResultRepository) {
        this.taskRepository = taskRepository;
        this.productService = productService;
        this.userService = userService;
        this.sprintService = sprintService;
        this.taskResultRepository = taskResultRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAllTasks() { return taskRepository.findAll(); }

    @Override
    public Task addTask(Task task, User assignedFrom) {
        Product product = productService.findByName(task.getProductName());
        User assignedTo = userService.findByUsername(task.getAssignedToName());
        Sprint sprint = sprintService.findByName(task.getSprintName());
        task.setProduct(product);
        task.setAssignedTo(assignedTo);
        task.setAssignedFrom(assignedFrom);
        task.setSprint(sprint);
        TaskResult taskResult = new TaskResult();
        TaskResult createdTaskResult = taskResultRepository.save(taskResult);
        task.setTaskResult(createdTaskResult);
        Task created = taskRepository.save(task);
        sprint.getTasks().add(created);
        return taskRepository.save(task);
    }

    @Override
    @Transactional(readOnly = true)
    public Task getTaskById(Long taskId) {return taskRepository.findById(taskId).get();}

    @Override
    @Transactional(readOnly = true)
    public Task getTaskByUserId(Long userId) {return taskRepository.findById(userId).get();}

    @Override
    @Transactional(readOnly = true)
    public Task updateTask(Task task) {return taskRepository.save(task);}

    @Override
    @Transactional(readOnly = true)
    public void deleteTaskById(Long taskId) {taskRepository.deleteById(taskId);}
}
