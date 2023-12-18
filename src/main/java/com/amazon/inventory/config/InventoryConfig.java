package com.amazon.inventory.config;

import com.amazon.inventory.interceptor.InventoryInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InventoryConfig implements WebMvcConfigurer {

    @Autowired
    private InventoryInterceptor inventoryInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(inventoryInterceptor).addPathPatterns("/inventory/*");
    }

}
