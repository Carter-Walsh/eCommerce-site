package com.capstone.eCommercesite.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    private double price;
    private String availability;
    private String brand;
    private String categories;

    @Column(name = "image_url")
    private String imageUrl;
    
    @Column(name = "product_name")
    private String productName;

    @Column(name = "primaryCategory")
    private String primaryCategory;
    private String weight;

    @OneToMany(mappedBy = "product")
    private List<OrdersProducts> ordersProducts = new ArrayList<>();

    public Product() {}

    public Product(double price, String availability, String brand, String categories, String imageUrl, String productName, String primaryCategory, String weight) {
        this.price = price;
        this.availability = availability;
        this.brand = brand;
        this.categories = categories;
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.primaryCategory = primaryCategory;
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public String getprimaryCategory() {
        return primaryCategory;
    }

    public void setprimaryCategory(String primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public List<OrdersProducts> getOrdersProducts() {
        return ordersProducts;
    }

    public void setOrdersProducts(List<OrdersProducts> ordersProducts) {
        this.ordersProducts = ordersProducts;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", price=" + price +
                ", availability='" + availability + '\'' +
                ", brand='" + brand + '\'' +
                ", categories='" + categories + '\'' +
                ", image_url='" + imageUrl + '\'' +
                ", productName='" + productName + '\'' +
                ", primaryCategory='" + primaryCategory + '\'' +
                ", weight=" + weight +
                '}';
    }
}
