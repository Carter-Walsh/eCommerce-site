package com.capstone.eCommercesite.repository;

import com.capstone.eCommercesite.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
}
