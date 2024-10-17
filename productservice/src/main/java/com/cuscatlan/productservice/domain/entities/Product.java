package com.cuscatlan.productservice.domain.entities;

public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String image;

    public Product(Long id, String name, String description, double price,String category, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }
}

