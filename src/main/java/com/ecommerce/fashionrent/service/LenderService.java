package com.ecommerce.fashionrent.service;


import com.ecommerce.fashionrent.dto.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class LenderService {

    public ProductDto saveProduct(ProductDto productDto, List<MultipartFile> fileList){
        System.out.println(productDto +""+ fileList);
        return productDto;
    }
}
