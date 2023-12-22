package com.ecommerce.fashionrent.dto.specification;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface RentedProductDtoSpecification {

    Integer getProductId();
    String getProductName();
    BigDecimal getRrp();
    BigDecimal getRentPrice();
    String[] getImageUrl();
    LocalDate getDateFrom();
    LocalDate getDateTo();


}
