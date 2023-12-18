package com.amazon.inventory.repository;

import com.amazon.inventory.models.Product;
import com.amazon.inventory.models.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductRepository {

    private final Map<String, Product> productStore = new HashMap<>();

    public String addProduct(Product product) {
        productStore.put(product.getId(), product);
        return product.getId();
    }

    public String deleteProduct(String id) {
        Product product = productStore.remove(id);
        if(product == null){
            return "No such product exist";
        }
        return "Successfully deleted";
    }

    public Product getProductById(String id) {
        return productStore.get(id);
    }

    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();

        for(Map.Entry<String, Product> productEntry: productStore.entrySet()){
            if(productEntry.getValue().getName().equals(name)){
                products.add(productEntry.getValue());
            }
        }
        return products;
    }

    public List<Product> searchByCategory(ProductCategory category) {
        List<Product> products = new ArrayList<>();

        for(Map.Entry<String, Product> productEntry: productStore.entrySet()){
            if(productEntry.getValue().getCategory().equals(category)){
                products.add(productEntry.getValue());
            }
        }
        return products;
    }

    public List<Product> searchByBrand(String brand) {
        List<Product> products = new ArrayList<>();

        for(Map.Entry<String, Product> productEntry: productStore.entrySet()){
            if(productEntry.getValue().getBrand().equals(brand)){
                products.add(productEntry.getValue());
            }
        }
        return products;
    }

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();

        for(Map.Entry<String, Product> productEntry: productStore.entrySet()){
            products.add(productEntry.getValue());
        }
        return products;
    }
}
