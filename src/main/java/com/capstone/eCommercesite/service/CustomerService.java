package com.capstone.eCommercesite.service;

import com.capstone.eCommercesite.model.Customer;
import com.capstone.eCommercesite.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // create customer in DB
    public String createCustomer(Customer customer) {
        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();
        String emailAddress = customer.getEmailAddress();
        String password = customer.getPassword();

        // checking to find if that email already exists in our database. If yes, return a failure message. If not, create customer account
        Customer existingCustomer = customerRepository.findByEmailAddress(emailAddress);

        if (existingCustomer != null) {
            return "There is already a user in the database with that email address.";
        } else {
            Customer newCustomer = new Customer(firstName, lastName, emailAddress, password);
            customerRepository.save(newCustomer);
            return "User with a name of " + firstName + " has been added to the Database!";
        }
    }

    // verify customer for Login
    public boolean verifyCustomer(String emailAddress, String password) {
        Customer customerByEmail = customerRepository.findByEmailAddress(emailAddress);
        if (customerByEmail != null) {
            return customerByEmail.getPassword().equals(password);
        }

        return false;
    }

    // read customer from DB
    public Optional<Customer> getCustomer(int id) {
        return customerRepository.findById(id);
    }

    // update customer from DB
    public void updateCustomer(int id, Customer customer) {
        Customer customerToUpdate = customerRepository.findById(id).get();

        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setEmailAddress(customer.getEmailAddress());
        customerToUpdate.setPassword(customer.getPassword());

        customerRepository.save(customerToUpdate);
    }

    // delete customer from DB
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

}
