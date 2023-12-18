package com.amazon.inventory.factory;

import com.amazon.inventory.dto.FilterDto;
import com.amazon.inventory.dto.filter.BrandFilter;
import com.amazon.inventory.dto.filter.CategoryFilter;
import com.amazon.inventory.dto.filter.Filter;
import com.amazon.inventory.dto.filter.NameFilter;
import com.amazon.inventory.models.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FilterFactory {

    private Map<String, Filter> filterMap;

    @Autowired
    public FilterFactory(Set<Filter> filters){
        filterMap = new HashMap<>();
        createFilterMap(filters);
    }

    private void createFilterMap(Set<Filter> filters) {
        for(Filter filter: filters){
            filterMap.put(filter.getClass().getSimpleName(), filter);
        }
    }

    public Filter getByName(String name){
        NameFilter nameFilter = (NameFilter) filterMap.get("NameFilter");
        nameFilter.setName(name);
        return nameFilter;
    }

    public Filter getByBrand(String brand){
        BrandFilter brandFilter = (BrandFilter) filterMap.get("BrandFilter");
        brandFilter.setBrand(brand);
        return brandFilter;
    }

    public Filter getByCategory(ProductCategory productCategory){
        CategoryFilter categoryFilter = (CategoryFilter) filterMap.get("CategoryFilter");
        categoryFilter.setCategory(productCategory);
        return categoryFilter;
    }

    public List<Filter> getAllFilters(FilterDto filterDto) {
        List<Filter> filterList = new ArrayList<>();
        if(filterDto.getBrand() != null){
            filterList.add(getByBrand(filterDto.getBrand()));
        }
        if(filterDto.getCategory() != null){
            filterList.add(getByCategory(filterDto.getCategory()));
        }
        if(filterDto.getName() != null){
            filterList.add(getByName(filterDto.getName()));
        }
        return filterList;
    }
}
