package com.cuscatlan.productservice.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuscatlan.productservice.application.services.GetProductService;
import com.cuscatlan.productservice.domain.entities.Product;


@RestController
@RequestMapping("/products")
public class ProductController {
    private final GetProductService getProductService;
    
    public ProductController(GetProductService getProductService) {
        this.getProductService = getProductService;
    }

    @GetMapping("/getAllProducts")
    public List<Product> getMethodName() {
        return getProductService.getAllProducts();
    }
    
}
