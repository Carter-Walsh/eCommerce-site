package com.capstone.eCommercesite.service;

import com.capstone.eCommercesite.model.Customer;
import com.capstone.eCommercesite.model.Order;
import com.capstone.eCommercesite.model.OrdersProducts;
import com.capstone.eCommercesite.model.Product;
import com.capstone.eCommercesite.repository.CustomerRepository;
import com.capstone.eCommercesite.repository.OrdersProductsRepository;
import com.capstone.eCommercesite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrdersProductsRepository ordersProductsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    // create new order
    public void createOrder(int customerId, int productId) {

        // revisit the optional later
        Customer customer = customerRepository.findById(customerId).get();
        Product product = productRepository.findById(productId).get();

        Order order = new Order("test order");
        order.setCustomer(customer);
        OrdersProducts ordersProducts = new OrdersProducts();
        ordersProducts.setOrder(order);
        ordersProducts.setProduct(product);

        ordersProductsRepository.save(ordersProducts);
    }

    // retrieve items in order
    public List<Order> getItemsInOrder(int customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return customer.getOrders();
    }

}
