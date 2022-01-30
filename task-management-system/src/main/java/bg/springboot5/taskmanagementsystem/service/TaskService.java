package bg.springboot5.taskmanagementsystem.service;

import bg.springboot5.taskmanagementsystem.model.Task;
import bg.springboot5.taskmanagementsystem.model.User;

import java.util.List;

public  interface TaskService {
    List<Task> getAllTasks();

    Task addTask(Task task);

    Task getTaskById(Long task_id);

    Task getTaskByUserId(Long user_id);

    Task updateTask(Task task);

    void deleteTaskById(Long id);
}
