package bg.springboot5.taskmanagementsystem.service.impl;

import bg.springboot5.taskmanagementsystem.model.Task;
import bg.springboot5.taskmanagementsystem.model.User;
import bg.springboot5.taskmanagementsystem.repository.TaskRepository;
import bg.springboot5.taskmanagementsystem.repository.UserRepository;
import bg.springboot5.taskmanagementsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public Task addTask(Task task) {
        return null;
    }

    @Override
    public Task getTaskById(Long task_id) {
        return null;
    }

    @Override
    public Task getTaskByUserId(Long user_id) {
        return null;
    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }

    @Override
    public void deleteTaskById(Long id) {

    }
}
