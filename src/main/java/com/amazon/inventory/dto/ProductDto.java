package com.amazon.inventory.dto;

import com.amazon.inventory.models.ProductCategory;
import lombok.Data;

@Data
public class ProductDto {

    private String name;
    private ProductCategory category;
    private String brand;
}
