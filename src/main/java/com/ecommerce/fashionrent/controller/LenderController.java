package com.ecommerce.fashionrent.controller;

import com.ecommerce.fashionrent.dto.ProductDto;
import com.ecommerce.fashionrent.dto.specification.ProductDtoSpecification;
import com.ecommerce.fashionrent.security.UserPrincipal;
import com.ecommerce.fashionrent.service.AuthService;
import com.ecommerce.fashionrent.service.LenderService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/lender")
public class LenderController {

    @Autowired
    private  LenderService lenderservice;
    @Autowired
    private  AuthService authService;

    @PostMapping(
            path = "",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProductDto> saveProduct(@ParameterObject  ProductDto productDto,
                                               @RequestParam("file") List<MultipartFile> files) {
        UserPrincipal userPrincipal = authService.getUserPrincipal();
        Integer userId = Math.toIntExact(userPrincipal.getId());
        return new ResponseEntity<ProductDto>(lenderservice.saveProduct(productDto, files, userId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDtoSpecification>> getProduct() {
        UserPrincipal userPrincipal = authService.getUserPrincipal();
        Integer userId = Math.toIntExact(userPrincipal.getId());
//        return null;
        return new ResponseEntity<List<ProductDtoSpecification>>(lenderservice.getProduct(userId),
                HttpStatus.OK);
    }

}
