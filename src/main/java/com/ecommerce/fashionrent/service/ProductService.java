package com.ecommerce.fashionrent.service;

import com.ecommerce.fashionrent.dto.ProductDto;
import com.ecommerce.fashionrent.dto.ProductFilter;
import com.ecommerce.fashionrent.dto.specification.ProductDtoSpecification;

import com.ecommerce.fashionrent.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getAllProducts(ProductFilter productFilter) {
        List<ProductDtoSpecification> productDtos = productRepository.getAllProducts();
        List<ProductDto> products = new ArrayList<>();
        List<ProductDtoSpecification> filtered =   productDtos.stream().filter(e ->
            typeFilter(productFilter, e) && brandFilter(productFilter, e)
                    && genderFilter(productFilter, e) && occassionFilter(productFilter, e)
                    && sizeFilter(productFilter, e) && fitFilter(productFilter, e)
                    && priceFilter(productFilter, e)).collect(Collectors.toList());

        for (ProductDtoSpecification ptos : filtered) {
            ProductDto productDto = new ProductDto();
            productDto.setProductId(ptos.getProductId());
            productDto.setProductName(ptos.getProductName());
            productDto.setRentPrice(ptos.getRentPrice());
            productDto.setRrp(ptos.getRrp());
            productDto.setBrand(ptos.getBrand());
            productDto.setCategory(ptos.getCategory());
            productDto.setOccasion(ptos.getOccasion());
            productDto.setSize(ptos.getSize());
            productDto.setFit(ptos.getFit());
            productDto.setType(ptos.getType());
            productDto.setImageUrls(ptos.getImageUrl());
            products.add(productDto);
        }
        return products;
    }

    public void addProduct(ProductDto productDto){
            
    }

    private boolean typeFilter(ProductFilter productFilter, ProductDtoSpecification e) {
        if (productFilter.getType() != null) {
            if(productFilter.getType().contains(e.getType())){
                return true;
            }
            return false;
        }
        return true;
    }

    private boolean brandFilter(ProductFilter productFilter, ProductDtoSpecification e) {
        if (productFilter.getBrands() != null) {
            if(productFilter.getBrands().contains(e.getBrand())){
                return true;
            }
            return false;
        }
        return true;
    }

    private boolean fitFilter(ProductFilter productFilter, ProductDtoSpecification e) {
        if (productFilter.getFit() != null) {
            if(productFilter.getFit().contains(e.getFit())){
                return true;
            }
            return false;
        }
        return true;
    }

    private boolean sizeFilter(ProductFilter productFilter, ProductDtoSpecification e) {
        if (productFilter.getSize() != null) {
            if(productFilter.getSize().contains(e.getSize())){
                return true;
            }
            return false;
        }
        return true;
    }

    private boolean occassionFilter(ProductFilter productFilter, ProductDtoSpecification e) {
        if (productFilter.getOccasions() != null) {
            if(productFilter.getOccasions().contains(e.getOccasion())){
                return true;
            }
            return false;
        }
        return true;
    }

    private boolean genderFilter(ProductFilter productFilter, ProductDtoSpecification e) {
        if (productFilter.getGender() != null) {
            if(productFilter.getGender().contains(e.getGender())){
                return true;
            }
            return false;
        }
        return true;
    }

    private boolean priceFilter(ProductFilter productFilter, ProductDtoSpecification e) {
        if (productFilter.getMinPrice() != null && productFilter.getMaxPrice() != null) {
            if((e.getRentPrice().intValue() >= productFilter.getMinPrice()
                    && e.getRentPrice().intValue() <= productFilter.getMaxPrice())){
                return true;
            }
            return false;
        }
        return true;
    }
}
