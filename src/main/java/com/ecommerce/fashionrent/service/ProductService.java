package com.ecommerce.fashionrent.service;

import com.ecommerce.fashionrent.dto.ProductDto;
import com.ecommerce.fashionrent.dto.specification.ProductDtoSpecification;
import com.ecommerce.fashionrent.entity.ProductImageUrl;
import com.ecommerce.fashionrent.repository.ProductRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.links.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtos = new ArrayList<>();
        for (ProductDtoSpecification ptos : productRepository.getAllProducts()) {
            ProductDto productDto = new ProductDto();
            productDto.setProductId(ptos.getProductId());
            productDto.setProductName(ptos.getProductName());
            productDto.setRentPrice(ptos.getRentPrice());
            productDto.setRrp(ptos.getRrp());
            productDto.setBrand(ptos.getBrand());
            productDto.setCategory(ptos.getCategory());
            productDto.setOccasion(ptos.getOccasion());
            int index = productDtos.indexOf(productDto);
            if (index != -1) {
                productDto = productDtos.get(index);
            } else {
                productDto.setProductImageUrls(new ArrayList<>());
                productDtos.add(productDto);
            }
            ProductImageUrl productImageUrl = new ProductImageUrl();
            productImageUrl.setImageUrl(ptos.getImageUrl());
            productImageUrl.setIsthumbnail(ptos.isThumbnail());
            productDto.getProductImageUrls().add(productImageUrl);


        }
        return new ArrayList<ProductDto>(productDtos);
    }
}
