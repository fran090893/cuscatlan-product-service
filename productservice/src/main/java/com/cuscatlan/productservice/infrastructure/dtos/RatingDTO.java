package com.cuscatlan.productservice.infrastructure.dtos;

public class RatingDTO {
    private Double rate;
    private Integer count;

    public RatingDTO(Double rate, Integer count) {
        this.rate = rate;
        this.count = count;
    }
    // Getters y Setters
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
