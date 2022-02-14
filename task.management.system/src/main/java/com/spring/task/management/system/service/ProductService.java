package com.spring.task.management.system.service;

import com.spring.task.management.system.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product addProduct(Product product);

    Product getProductByProductId (Long productId);

    Product getGetProductByOwnerId (Long ownerId);

    Product updateProduct(Product product);

    void deleteProductById(Long productId);
}
