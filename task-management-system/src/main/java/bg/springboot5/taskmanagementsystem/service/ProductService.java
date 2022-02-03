package bg.springboot5.taskmanagementsystem.service;

import bg.springboot5.taskmanagementsystem.model.Product;
import bg.springboot5.taskmanagementsystem.model.Requirement;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product addProduct(Product product);

    Product getProductByProductId (Long productId);

    Product getGetProductByOwnerId (Long ownerId);

    Product updateProduct(Product product);

    void deleteProductById(Long productId);
}
