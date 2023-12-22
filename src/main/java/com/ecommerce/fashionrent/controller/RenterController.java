package com.ecommerce.fashionrent.controller;

import com.ecommerce.fashionrent.dto.specification.RentedProductDtoSpecification;
import com.ecommerce.fashionrent.security.UserPrincipal;
import com.ecommerce.fashionrent.service.AuthService;
import com.ecommerce.fashionrent.service.RenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/renter")
@RequiredArgsConstructor
public class RenterController {


    private final AuthService authService;
    private final RenterService renterService;


    @GetMapping
    public List<RentedProductDtoSpecification> getAllRentingProduct(){
        UserPrincipal userPrincipal = authService.getUserPrincipal();
        Integer userId = Math.toIntExact(userPrincipal.getId());
        return renterService.getAllRentedProduct(userId);

    }
}
