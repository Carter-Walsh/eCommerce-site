package com.capstone.eCommercesite.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

// JOIN TABLE

@Entity(name = "orders_products")
public class OrdersProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_products_id")
    private int ordersProductsId;

    // foreign key to the order_id column of orders table
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    // foreign key to the product_id of the products table
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    public OrdersProducts() {}

    public int getOrdersProductsId() {
        return ordersProductsId;
    }

    public void setOrdersProductsId(int ordersProductsId) {
        this.ordersProductsId = ordersProductsId;
    }

    // this is being ignored so that the ManyToMany relationship doesn't create infinite recursion in a response to a user request
    @JsonIgnore
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    // this is being ignored so that the ManyToMany relationship doesn't create infinite recursion in a response to a user request
    @JsonIgnore
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrdersProducts{" +
                "ordersProductsId=" + ordersProductsId +
                ", order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersProducts that = (OrdersProducts) o;

        if (ordersProductsId != that.ordersProductsId) return false;
        if (quantity != that.quantity) return false;
        if (!order.equals(that.order)) return false;
        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        int result = ordersProductsId;
        result = 31 * result + order.hashCode();
        result = 31 * result + product.hashCode();
        result = 31 * result + quantity;
        return result;
    }
}
