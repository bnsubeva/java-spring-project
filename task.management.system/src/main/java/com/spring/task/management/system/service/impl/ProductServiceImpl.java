package com.spring.task.management.system.service.impl;

import com.spring.task.management.system.entity.Requirement;
import com.spring.task.management.system.entity.User;
import com.spring.task.management.system.exception.EntityNotFoundException;
import com.spring.task.management.system.entity.Product;
import com.spring.task.management.system.repository.ProductRepository;
import com.spring.task.management.system.service.ProductService;
import com.spring.task.management.system.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final RequirementService requirementService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, RequirementService requirementService) {
        this.productRepository = productRepository;
        this.requirementService = requirementService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
      return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findByName(String name) {
        return productRepository.findByProductName(name).orElseThrow(
            () -> new EntityNotFoundException("Product with such name " + name + " doesn't exist!")
        );
    }

    @Override
    public Product addProduct(Product product, User productOwner) {
        AtomicLong atomicLong = new AtomicLong();
        product.setProductOwner(productOwner);
        String[] requirements = product.getRequirementList().split(",");
        for (String requirement : requirements) {
            Requirement req = new Requirement("Requirement No:" + atomicLong.getAndDecrement(), requirement, product);
            Requirement created = requirementService.addRequirement(req);
            product.getRequirements().add(created);
        }
        return productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductByProductId(Long productId) {
        return productRepository.findById(productId).orElseThrow(
            () -> new EntityNotFoundException("Product with such id " + productId + " doesn't exist!")
        );
    }

    @Override
    @Transactional(readOnly = true)
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
