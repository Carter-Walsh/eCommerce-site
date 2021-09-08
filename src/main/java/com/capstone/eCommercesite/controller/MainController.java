package com.capstone.eCommercesite.controller;

import com.capstone.eCommercesite.model.Product;
import com.capstone.eCommercesite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @GetMapping("/homepage")
    public List<Product> getHomepageProducts() {
        return productService.getHomepageProducts();
    }

    @PostMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
