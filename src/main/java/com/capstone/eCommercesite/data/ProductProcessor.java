package com.capstone.eCommercesite.data;

import com.capstone.eCommercesite.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class ProductProcessor implements ItemProcessor<ProductInput, Product> {

    @Override
    public Product process(ProductInput item) throws Exception {
        final double price = item.getPrice();
        final String availability = item.getAvailability();
        final String brand = item.getBrand();
        final String categories = item.getCategories();
        final String imageUrl = item.getImage_url();
        final String productName = item.getProduct_name();
        final String primaryCategory = item.getPrimary_category();
        final String weight = item.getWeight();

        final Product product = new Product(price, availability, brand, categories, imageUrl, productName, primaryCategory, weight);

        return product;
    }

}
