package com.ecommerce.fashionrent.dto.specification;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ProductDtoSpecification {

    Integer getProductId();
    String getProductName();
    BigDecimal getRrp();
    BigDecimal getRentPrice();
    String[] getImageUrl();
    String getBrand();
    String getOccasion();
    String getCategory();
    String getType();
    String getFit();
    String getGender();
    String getSize();
//    boolean isThumbnail();
    LocalDate getAvailableFrom();
    Double getSecurityDeposit();

}
