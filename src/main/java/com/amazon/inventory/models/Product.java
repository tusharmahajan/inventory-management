package com.amazon.inventory.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private String id;
    private String name;
    private ProductCategory category;
    private String brand;
}
