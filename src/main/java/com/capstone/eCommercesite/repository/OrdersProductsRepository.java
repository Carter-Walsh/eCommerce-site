package com.capstone.eCommercesite.repository;

import com.capstone.eCommercesite.model.OrdersProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersProductsRepository extends CrudRepository<OrdersProducts, Integer> {
}
