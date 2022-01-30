package bg.springboot5.taskmanagementsystem.repository;

import bg.springboot5.taskmanagementsystem.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
