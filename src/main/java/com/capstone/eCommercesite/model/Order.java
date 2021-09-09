package com.capstone.eCommercesite.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    // foreign key to customer_id in the customers table
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "order_name")
    private String orderName;

    @OneToMany(mappedBy = "order")
    private List<OrdersProducts> ordersProducts = new ArrayList<>();

    public Order() {}

    public Order (String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    // this is being ignored so that the ManyToMany relationship doesn't create infinite recursion in a response to a user request
    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public List<OrdersProducts> getOrdersProducts() {
        return ordersProducts;
    }

    public void setOrdersProducts(List<OrdersProducts> ordersProducts) {
        this.ordersProducts = ordersProducts;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", orderName='" + orderName + '\'' +
                ", ordersProducts=" + ordersProducts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (customer != null ? !customer.equals(order.customer) : order.customer != null) return false;
        if (orderName != null ? !orderName.equals(order.orderName) : order.orderName != null) return false;
        return ordersProducts != null ? ordersProducts.equals(order.ordersProducts) : order.ordersProducts == null;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (orderName != null ? orderName.hashCode() : 0);
        result = 31 * result + (ordersProducts != null ? ordersProducts.hashCode() : 0);
        return result;
    }
}


