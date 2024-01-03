package com.ecommerce.fashionrent.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "deliveryaddress")
@Data
@Entity
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "userid")
    private Long userId;
    @Column(name = "addressline1")
    private String addressLine1;
    @Column(name = "addressline2")
    private String addressLine2;
    private String town;
    private String postcode;
    private boolean marketEmails;
    private boolean sms;
    @Column(name = "imageurl")
    private String imageUrl;

}
