package com.ecommerce.fashionrent.controller;

import com.ecommerce.fashionrent.dto.ProductDto;
import com.ecommerce.fashionrent.dto.ProductFilter;
import com.ecommerce.fashionrent.dto.specification.ProductDtoSpecification;
import com.ecommerce.fashionrent.service.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProduct(@Parameter ProductFilter productFilter){
        return productService.getAllProducts(productFilter);
    }

    @PostMapping
    public void postProduct(@RequestBody ProductDto productDto){

    }
}
