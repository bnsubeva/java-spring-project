package com.spring.task.management.system.repository;

import com.spring.task.management.system.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
