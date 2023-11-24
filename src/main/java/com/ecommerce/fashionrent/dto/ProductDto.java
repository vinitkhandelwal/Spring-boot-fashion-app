package com.ecommerce.fashionrent.dto;

import com.ecommerce.fashionrent.entity.ProductImageUrl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ProductDto {

    private Integer productId;
    private String productName;
    private BigDecimal rrp;
    private BigDecimal rentPrice;
    private String brand;
    private String occasion;
    private String category;
    private List<ProductImageUrl> productImageUrls;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getRrp() {
        return rrp;
    }

    public void setRrp(BigDecimal rrp) {
        this.rrp = rrp;
    }

    public BigDecimal getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(BigDecimal rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<ProductImageUrl> getProductImageUrls() {
        return productImageUrls;
    }

    public void setProductImageUrls(List<ProductImageUrl> productImageUrls) {
        this.productImageUrls = productImageUrls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
