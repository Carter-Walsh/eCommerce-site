package com.capstone.eCommercesite.repository;

import com.capstone.eCommercesite.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    // will return 20 results to display on the homepage
    @Query(nativeQuery = true, value = "SELECT * FROM products p ORDER BY product_id LIMIT 20")
    List<Product> getHomepageProducts();

    List<Product> findByProductNameStartsWithIgnoreCase(String query);
    List<Product> findByProductNameContainingIgnoreCase(String query);
    List<Product> findByProductNameEndsWithIgnoreCase(String query);


}
