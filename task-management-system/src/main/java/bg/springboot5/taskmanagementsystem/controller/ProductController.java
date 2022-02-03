package bg.springboot5.taskmanagementsystem.controller;

import bg.springboot5.taskmanagementsystem.model.Product;
import bg.springboot5.taskmanagementsystem.model.Requirement;
import bg.springboot5.taskmanagementsystem.service.ProductService;
import bg.springboot5.taskmanagementsystem.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Product getProduct() {
        return Product.builder().productName("Product").productId(83838L).build();
    }
}
