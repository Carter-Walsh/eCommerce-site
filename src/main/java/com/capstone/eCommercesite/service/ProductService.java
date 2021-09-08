package com.capstone.eCommercesite.service;

import com.capstone.eCommercesite.model.Product;
import com.capstone.eCommercesite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Product> getProduct(int id) {
        return productRepository.findById(id);
    }

    public List<Product> getHomepageProducts() {
        return entityManager.createQuery("SELECT p FROM products p ORDER BY product_id",
                Product.class).setMaxResults(20).getResultList();
    }

}
