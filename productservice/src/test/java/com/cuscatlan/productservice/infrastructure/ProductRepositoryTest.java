package com.cuscatlan.productservice.infrastructure;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.cuscatlan.productservice.domain.entities.Product;
import com.cuscatlan.productservice.infrastructure.dtos.ProductDTO;
import com.cuscatlan.productservice.infrastructure.dtos.RatingDTO;
import com.cuscatlan.productservice.infrastructure.repositories.ProductRepository;

public class ProductRepositoryTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnListOfProducts() {
        //Arrange

        // Simulate response external API
        ProductDTO[] mockResponse = new ProductDTO[] {
            new ProductDTO(1L, "Product 1", 100.0, "Description 1", "Category 1", "image1.jpg", new RatingDTO(4.5, 100)),
            new ProductDTO(2L, "Product 2", 200.0, "Description 2", "Category 2", "image2.jpg", new RatingDTO(4.7, 200))
        };

        // Configure the simulated behavior of the RestTemplate
        when(restTemplate.getForObject("https://fakestoreapi.com/products", ProductDTO[].class))
            .thenReturn(mockResponse);

        //Act

        //Call the method we are testing
        List<Product> products = productRepository.getAllProducts();

        //Assert
        assertNotNull(products);
        assertEquals(2, products.size());

        Product firstProduct = products.get(0);
        assertEquals(1L, firstProduct.getId());
        assertEquals("Product 1", firstProduct.getName());
        assertEquals(100.0, firstProduct.getPrice());
    }
}
