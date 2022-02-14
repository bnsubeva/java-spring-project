package com.spring.task.management.system.controller;

import com.spring.task.management.system.entity.Product;

import com.spring.task.management.system.entity.User;
import com.spring.task.management.system.service.ProductService;
import com.spring.task.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public ProductController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product";
    }

    @GetMapping("/product-form")
    public String getProductForm(Model model) {
        if (!model.containsAttribute("product")) {
            model.addAttribute("product", new Product());
        }
        return "product-form";
    }

    @PostMapping("/product-form")
    public String addProduct(@ModelAttribute Product product, Authentication auth) {
        User user = userService.findByUsername(((User)auth.getPrincipal()).getUsername());
        productService.addProduct(product, user);
        return "redirect:/products";
    }

}
