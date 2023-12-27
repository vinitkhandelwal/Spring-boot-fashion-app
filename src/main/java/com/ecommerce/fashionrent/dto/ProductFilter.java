package com.ecommerce.fashionrent.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductFilter {

    private List<String> type;
    private List<String> occasions;
    private List<String> brands;
    private List<String> gender;
    private List<String> size;
    private List<String> fit;
    private Integer minPrice;
    private Integer maxPrice;

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public List<String> getOccasions() {
        return occasions;
    }

    public void setOccasions(List<String> occasions) {
        this.occasions = occasions;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public List<String> getGender() {
        return gender;
    }

    public void setGender(List<String> gender) {
        this.gender = gender;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public List<String> getFit() {
        return fit;
    }

    public void setFit(List<String> fit) {
        this.fit = fit;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }
}
