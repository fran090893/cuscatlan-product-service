package com.cuscatlan.productservice.domain.repositories;

import java.util.List;

import com.cuscatlan.productservice.domain.entities.Product;

public interface IProductRepository {
    List<Product> getAllProducts();
}
