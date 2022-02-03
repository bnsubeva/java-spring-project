package bg.springboot5.taskmanagementsystem.repository;

import bg.springboot5.taskmanagementsystem.model.Product;
import bg.springboot5.taskmanagementsystem.model.Requirement;
import bg.springboot5.taskmanagementsystem.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
