package com.capstone.eCommercesite.repository;

import com.capstone.eCommercesite.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {
}
