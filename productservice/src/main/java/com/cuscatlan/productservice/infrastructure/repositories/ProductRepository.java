package com.cuscatlan.productservice.infrastructure.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cuscatlan.productservice.domain.entities.Product;
import com.cuscatlan.productservice.domain.repositories.IProductRepository;
import com.cuscatlan.productservice.infrastructure.dtos.ProductDTO;

@Component
public class ProductRepository implements IProductRepository {
    private final  RestTemplate restTemplate;
    private final String apiUrl = "https://fakestoreapi.com/products";

    public ProductRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            ProductDTO[] products = restTemplate.getForObject(apiUrl, ProductDTO[].class);

            return Arrays.stream(products)
                .map(productDTO -> new Product(productDTO.getId(), productDTO.getTitle(), productDTO.getDescription(), productDTO.getPrice(),productDTO.getCategory(), productDTO.getImage()))
                .toList();
        } catch (Exception e) {
            throw new RuntimeException("Error getting products from external API");
        }
    }
}
