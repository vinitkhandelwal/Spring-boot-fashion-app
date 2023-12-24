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


}
