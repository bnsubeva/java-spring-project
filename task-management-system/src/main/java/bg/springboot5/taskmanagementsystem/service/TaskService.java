package bg.springboot5.taskmanagementsystem.service;

import bg.springboot5.taskmanagementsystem.model.Task;
import bg.springboot5.taskmanagementsystem.model.User;

import java.util.List;

public  interface TaskService {
    List<Task> getAllTasks();

    Task addTask(Task task);

    Task getTaskById(Long taskId);

    Task getTaskByUserId(Long userId);

    Task updateTask(Task task);

    void deleteTaskById(Long taskId);
}
