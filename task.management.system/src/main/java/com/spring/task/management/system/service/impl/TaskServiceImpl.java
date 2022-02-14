package com.spring.task.management.system.service.impl;

import com.spring.task.management.system.entity.Task;
import com.spring.task.management.system.repository.TaskRepository;
import com.spring.task.management.system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() { return taskRepository.findAll(); }

    @Override
    public Task addTask(Task task) { return taskRepository.save(task);}

    @Override
    public Task getTaskById(Long taskId) {return taskRepository.findById(taskId).get();}

    @Override
    public Task getTaskByUserId(Long userId) {return taskRepository.findById(userId).get();}

    @Override
    public Task updateTask(Task task) {return taskRepository.save(task);}

    @Override
    public void deleteTaskById(Long taskId) {taskRepository.deleteById(taskId);}
}
