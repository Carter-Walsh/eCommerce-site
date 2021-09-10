package com.capstone.eCommercesite.controller;

import com.capstone.eCommercesite.model.Customer;
import com.capstone.eCommercesite.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // create account for a new user
    @PostMapping("/register-customer")
    public String createUserAccount(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    // authenticate a user for login
    @GetMapping("/login")
    public boolean verifyLoginRequest(@RequestParam(name = "emailAddress", required = true) String emailAddress, @RequestParam(name = "password", required = true) String password) {
        boolean result = customerService.verifyCustomer(emailAddress, password);
        return result;
    }

    // read customer account information
    @GetMapping("/customer-information/{id}")
    public Optional<Customer> getCustomer(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    // update a customer's account
    @PutMapping("/update-customer/{id}")
    public String updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return "Customer with a name of " + customer.getFirstName() + " was updated! :)";
    }

    // delete a customer's account
    @DeleteMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "Customer was deleted. We're sorry to see you go :(";
    }



}
