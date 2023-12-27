package com.ecommerce.fashionrent.entity;


//import com.vividsolutions.jts.geom.Point;
import lombok.Data;
//import org.geolatte.geom.Point;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Point;
import org.postgis.Geometry;



import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "productlenders")
//@Data
public class ProductLenders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "productname")
    private String productName;
    private BigDecimal rrp;
    @Column(name = "rentprice")
    private BigDecimal rentPrice;
    private String brand;
    private String category;
    private String occasion;
    @Column(name = "lenderid")
    private Integer lenderId;
    private String type;
    private String gender;
    private String size;
    private String fit;
    private Double latitude;
    private Double longitude;
    @Column(name = "availablefrom")
    private LocalDate availableFrom;
    @Column(name = "securitydeposit")
    private Double securityDeposit;
    @Transient
    private String[] imageUrl;

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

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLenderId() {
        return lenderId;
    }

    public void setLenderId(Integer lenderId) {
        this.lenderId = lenderId;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String[] getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String[] imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDate getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(LocalDate availableFrom) {
        this.availableFrom = availableFrom;
    }

    public Double getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(Double securityDeposit) {
        this.securityDeposit = securityDeposit;
    }
}
