package com.amazon.inventory.service;

import com.amazon.inventory.dto.ProductDto;
import com.amazon.inventory.dto.filter.Filter;
import com.amazon.inventory.models.Product;
import com.amazon.inventory.models.ProductCategory;
import com.amazon.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public String addProduct(ProductDto productDto) {
        //put validations on product fields

        Product product = Product.builder()
                .id(UUID.randomUUID().toString())
                .name(productDto.getName())
                .brand(productDto.getBrand())
                .category(productDto.getCategory()).build();

        return productRepository.addProduct(product);
    }

    public String deleteProduct(String id) {
        // validations on id
       return productRepository.deleteProduct(id);
    }

    public String updateProduct(String id, ProductDto productDto) {
        // validations on product
        Product product = productRepository.getProductById(id);

        if(product == null){
            return "Product does not exist";
        }

        if(productDto.getBrand() != null){
            product.setBrand(productDto.getBrand());
        }
        if(productDto.getName() != null){
            product.setName(productDto.getName());
        }
        if(productDto.getCategory() != null){
            product.setCategory(productDto.getCategory());
        }
        return productRepository.addProduct(product);
    }

    public List<Product> getFilteredProducts(List<Filter> filterList) {
        List<Product> productList = productRepository.getAllProducts();

        for(Filter filter: filterList){
            List<Product> filteredProducts = new ArrayList<>();
            for(Product product: productList){
                if(filter.filter(product)){
                    filteredProducts.add(product);
                }
            }
            productList = filteredProducts;
        }
        return productList;
    }
}
