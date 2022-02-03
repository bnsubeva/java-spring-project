package bg.springboot5.taskmanagementsystem.repository;

import bg.springboot5.taskmanagementsystem.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequirementRepository extends JpaRepository <Requirement,Long> {
}
