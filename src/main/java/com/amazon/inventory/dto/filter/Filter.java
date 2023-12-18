package com.amazon.inventory.dto.filter;

import com.amazon.inventory.models.Product;

import java.util.List;

public interface Filter {

    List<Product> search();

    boolean filter(Product product);
}
