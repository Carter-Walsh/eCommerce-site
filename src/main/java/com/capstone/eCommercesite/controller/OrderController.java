package com.capstone.eCommercesite.controller;

import com.capstone.eCommercesite.model.Order;
import com.capstone.eCommercesite.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    // add something to the customer's order
    @PostMapping("/create-order/{customerId}/{productId}")
    public String addToOrder(@PathVariable int customerId, @PathVariable int productId) {
        orderService.createOrder(customerId, productId);
        return "Order has been created!";
    }

    // get a list of items in the customers order
    @GetMapping("/get-products/{customerId}")
    public List<Order> getProductsInOrder(@PathVariable int customerId) {
        return orderService.getItemsInOrder(customerId);
    }

}
