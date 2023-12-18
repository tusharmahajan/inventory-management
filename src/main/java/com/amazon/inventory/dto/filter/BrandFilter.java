package com.amazon.inventory.dto.filter;

import com.amazon.inventory.models.Product;
import com.amazon.inventory.repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component("brand-filter")
public class BrandFilter implements Filter{

    private String brand;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> search() {
        return productRepository.searchByBrand(brand);
    }

    @Override
    public boolean filter(Product product) {
        return product.getBrand().equals(brand);
    }

}
