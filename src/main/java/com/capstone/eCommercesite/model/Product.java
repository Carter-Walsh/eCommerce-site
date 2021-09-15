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

    @Column(length = 1000)
    private String categories;

    @Column(name = "image_url", length = 15000)
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

    public double getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (availability != null ? !availability.equals(product.availability) : product.availability != null)
            return false;
        if (brand != null ? !brand.equals(product.brand) : product.brand != null) return false;
        if (categories != null ? !categories.equals(product.categories) : product.categories != null) return false;
        if (imageUrl != null ? !imageUrl.equals(product.imageUrl) : product.imageUrl != null) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (primaryCategory != null ? !primaryCategory.equals(product.primaryCategory) : product.primaryCategory != null)
            return false;
        if (weight != null ? !weight.equals(product.weight) : product.weight != null) return false;
        return ordersProducts != null ? ordersProducts.equals(product.ordersProducts) : product.ordersProducts == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productId;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (availability != null ? availability.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (primaryCategory != null ? primaryCategory.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (ordersProducts != null ? ordersProducts.hashCode() : 0);
        return result;
    }
}
