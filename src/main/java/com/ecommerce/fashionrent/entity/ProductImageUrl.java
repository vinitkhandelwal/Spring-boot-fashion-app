package com.ecommerce.fashionrent.entity;

import javax.persistence.*;

@Entity(name = "productimageurl")
public class ProductImageUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "productid")
    private Integer productId;
    @Column(name = "imageurl")
    private String imageUrl;
    private boolean isthumbnail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isIsthumbnail() {
        return isthumbnail;
    }

    public void setIsthumbnail(boolean isthumbnail) {
        this.isthumbnail = isthumbnail;
    }
}
