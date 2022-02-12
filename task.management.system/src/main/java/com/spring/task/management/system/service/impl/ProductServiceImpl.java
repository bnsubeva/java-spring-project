package com.spring.task.management.system.service.impl;

import com.spring.task.management.system.model.Product;
import com.spring.task.management.system.repository.ProductRepository;
import com.spring.task.management.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
      return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductByProductId(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Product getGetProductByOwnerId(Long ownerId) {
        return productRepository.findById(ownerId).get();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long productId) {
    productRepository.deleteById(productId);
    }
}
