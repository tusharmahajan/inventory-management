package com.amazon.inventory.controller;

import com.amazon.inventory.dto.FilterDto;
import com.amazon.inventory.dto.ProductDto;
import com.amazon.inventory.dto.filter.Filter;
import com.amazon.inventory.factory.FilterFactory;
import com.amazon.inventory.models.Product;
import com.amazon.inventory.models.ProductCategory;
import com.amazon.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private ProductService productService;

    @Autowired
    private FilterFactory filterFactory;

    @PostMapping("/add-product")
    public String addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    @DeleteMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);
    }

    @PutMapping("/update-product/{id}")
    public String updateProduct(@PathVariable String id, @RequestBody ProductDto productDto){
        return productService.updateProduct(id, productDto);
    }

    @GetMapping("/searchByName")
    public List<Product> searchByName(@RequestParam String name){
        Filter filter = filterFactory.getByName(name);
        return filter.search();
    }

    @GetMapping("/searchByCategory")
    public List<Product> searchByCategory(@RequestParam ProductCategory category){
        Filter filter = filterFactory.getByCategory(category);
        return filter.search();
    }

    @GetMapping("/searchByBrand")
    public List<Product> searchByBrand(@RequestParam String brand){
        Filter filter = filterFactory.getByBrand(brand);
        return filter.search();
    }

    @GetMapping("/search")
    public List<Product> search(FilterDto filterDto){
        List<Filter> filterList = filterFactory.getAllFilters(filterDto);
        return productService.getFilteredProducts(filterList);
    }
}
