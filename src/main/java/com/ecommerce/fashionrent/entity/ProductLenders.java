package com.ecommerce.fashionrent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "productLenders")
public class ProductLenders {

    @Id
    private Integer id;
    @Column(name = "productname")
    private String productName;
    private BigDecimal rrp;
    @Column(name = "rentPrice")
    private BigDecimal rentPrice;
    private String brand;
    private String category;
    private String ocassion;
    @Column(name = "lenderid")
    private Integer lenderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOcassion() {
        return ocassion;
    }

    public void setOcassion(String ocassion) {
        this.ocassion = ocassion;
    }

    public Integer getLenderId() {
        return lenderId;
    }

    public void setLenderId(Integer lenderId) {
        this.lenderId = lenderId;
    }
}