package com.ecommerce.fashionrent.controller;

import com.ecommerce.fashionrent.dto.ProductDto;
import com.ecommerce.fashionrent.service.LenderService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/lender")
@RequiredArgsConstructor
public class LenderController {

    private final LenderService lenderservice;

    @PostMapping(
            path = "",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProductDto> saveTodo(@Parameter(required = false)  ProductDto productDto,
                                               @RequestParam("file") List<MultipartFile> files) {
        return new ResponseEntity<ProductDto>(lenderservice.saveProduct(productDto, files),HttpStatus.OK);
    }
    public void createLender(@RequestBody ProductDto productDto){


    }
}
