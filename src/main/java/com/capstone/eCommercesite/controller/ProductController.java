package com.capstone.eCommercesite.controller;

import com.capstone.eCommercesite.model.Product;
import com.capstone.eCommercesite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // read single product from DB
    @GetMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    // return 20 products on homepage load
    @GetMapping("/homepage")
    public List<Product> getHomepageProducts() {
        return productService.getHomepageProducts();
    }

    // return results of a user search
    @GetMapping("/search/{query}")
    public List<Product> getSearchResults(@PathVariable String query) {
        return productService.getSearchResults(query);
    }
}
