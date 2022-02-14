package com.spring.task.management.system.service;

import com.spring.task.management.system.entity.Product;
import com.spring.task.management.system.entity.User;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product findByName(String name);

    Product addProduct(Product product, User productOwner);

    Product getProductByProductId (Long productId);

    Product getGetProductByOwnerId (Long ownerId);

    Product updateProduct(Product product);

    void deleteProductById(Long productId);
}
