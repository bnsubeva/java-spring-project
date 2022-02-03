package bg.springboot5.taskmanagementsystem.service.impl;

import bg.springboot5.taskmanagementsystem.model.Task;
import bg.springboot5.taskmanagementsystem.model.User;
import bg.springboot5.taskmanagementsystem.repository.TaskRepository;
import bg.springboot5.taskmanagementsystem.repository.UserRepository;
import bg.springboot5.taskmanagementsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
