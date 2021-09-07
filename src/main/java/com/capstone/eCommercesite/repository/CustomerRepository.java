package com.capstone.eCommercesite.repository;

import com.capstone.eCommercesite.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {
}
