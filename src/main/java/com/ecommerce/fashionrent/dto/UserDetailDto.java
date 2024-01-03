package com.ecommerce.fashionrent.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDetailDto {

    private Integer id;
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private boolean marketEmails;
    private boolean sms;
    private String imageUrl;

}
