package com.amazon.inventory.dto.filter;

import com.amazon.inventory.models.Product;
import com.amazon.inventory.repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component("name-filter")
public class NameFilter implements Filter{

    private String name;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> search() {
        return productRepository.searchByName(name);
    }

    @Override
    public boolean filter(Product product) {
        return product.getName().equals(name);
    }
}
