package bg.springboot5.taskmanagementsystem.repository;

import bg.springboot5.taskmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
