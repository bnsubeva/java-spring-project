package bg.springboot5.taskmanagementsystem.service.impl;

import bg.springboot5.taskmanagementsystem.model.Product;
import bg.springboot5.taskmanagementsystem.repository.ProductRepository;
import bg.springboot5.taskmanagementsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAllProducts() {
      return  productRepository.findAll();
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
