package com.capstone.eCommercesite.service;

import com.capstone.eCommercesite.model.Product;
import com.capstone.eCommercesite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // find one product by ID
    public Optional<Product> getProduct(int id) {
        return productRepository.findById(id);
    }

    // get a list of 20 products to display on the homepage of the website
    public List<Product> getHomepageProducts() {
        return productRepository.getHomepageProducts();
    }

    // retrieve products based on a user's search parameters:
    // first method is to find matches at beginning of product name, if nothing is found,
    // second method will find matches in the middle of a product name, if nothing is found,
    // last method will find matches at the end of product name
    public List<Product> getSearchResults(String query) {

        List<Product> startsWithResults = productRepository.findByProductNameStartsWithIgnoreCase(query);

        if (!startsWithResults.isEmpty()) {
            return startsWithResults;
        }

        List<Product> containsResults = productRepository.findByProductNameContainingIgnoreCase(query);

        if (!containsResults.isEmpty()) {
            return containsResults;
        }

        return productRepository.findByProductNameEndsWithIgnoreCase(query);
    }

}