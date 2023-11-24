package com.ecommerce.fashionrent.dto.specification;

import java.math.BigDecimal;

public interface ProductDtoSpecification {

    Integer getProductId();
    String getProductName();
    BigDecimal getRrp();
    BigDecimal getRentPrice();
    String getImageUrl();
    String getBrand();
    String getOccasion();
    String getCategory();
    boolean isThumbnail();
}
