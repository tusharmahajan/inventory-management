package com.amazon.inventory.dto.filter;

import com.amazon.inventory.models.Product;
import com.amazon.inventory.models.ProductCategory;
import com.amazon.inventory.repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component("category-filter")
public class CategoryFilter implements Filter{

    private ProductCategory category;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> search() {
        return productRepository.searchByCategory(category);
    }

    @Override
    public boolean filter(Product product) {
        return product.getCategory().equals(category);
    }
}
