package com.capstone.eCommercesite.repository;

import com.capstone.eCommercesite.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findByEmailAddress(@Param("emailAddress") String emailAddress);
    Customer findByPassword(@Param("password") String password);
}
