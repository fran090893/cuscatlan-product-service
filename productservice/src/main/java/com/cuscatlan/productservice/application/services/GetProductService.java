package com.cuscatlan.productservice.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cuscatlan.productservice.domain.entities.Product;
import com.cuscatlan.productservice.domain.repositories.IProductRepository;

@Service
public class GetProductService {
    private final IProductRepository productRepository;
    
    public GetProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
