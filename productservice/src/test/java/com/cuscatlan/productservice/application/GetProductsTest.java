package com.cuscatlan.productservice.application;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.cuscatlan.productservice.application.services.GetProductService;
import com.cuscatlan.productservice.domain.entities.Product;
import com.cuscatlan.productservice.infrastructure.repositories.ProductRepository;

public class GetProductsTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private GetProductService getProductService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnListOfProducts() {
        //Arrange
            List<Product> mockProducts = Arrays.asList(
                new Product(1L, "Product 1", "Description 1", 100.0,  "Category 1", "image1.jpg"),
                new Product(2L, "Product 2", "Description 2", 200.0,  "Category 2", "image2.jpg")
                );

            // Configure the simulated behavior of the ProductApiClient
            when(productRepository.getAllProducts()).thenReturn(mockProducts);
        //Act
            List<Product> products = getProductService.getAllProducts();
        //Assert
            assert(products.size() == 2);
            assert(products.get(0).getId() == 1L);
            assert(products.get(0).getName().equals("Product 1"));
            assert(products.get(0).getPrice() == 100.0);
    }
}
