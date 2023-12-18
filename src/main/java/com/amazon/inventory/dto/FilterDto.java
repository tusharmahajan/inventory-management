package com.amazon.inventory.dto;

import com.amazon.inventory.models.ProductCategory;
import lombok.Data;

@Data
public class FilterDto {

    private String name;
    private String brand;
    private ProductCategory category;
}
