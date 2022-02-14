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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

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

    @GetMapping("/product-form")
    public String getArticleForm(Model model, HttpSession session, RedirectAttributes redirectAttributes,
                                       Authentication auth) {
        User user = userService.findByUsername(((User)auth.getPrincipal()).getUsername());
        if (!model.containsAttribute("product")) {
            model.addAttribute("product", new Product());
        }
        return "product-form";
    }

}
