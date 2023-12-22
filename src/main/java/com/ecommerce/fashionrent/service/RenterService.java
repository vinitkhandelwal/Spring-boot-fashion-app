package com.ecommerce.fashionrent.service;

import com.ecommerce.fashionrent.dto.specification.RentedProductDtoSpecification;
import com.ecommerce.fashionrent.repository.ProductRepository;
import com.ecommerce.fashionrent.repository.RenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RenterService {

    private final RenterRepository renterRepository;

    public List<RentedProductDtoSpecification> getAllRentedProduct(Integer userId){
            return renterRepository.getRentedProducts(userId).stream()
                    .sorted((e1,e2) -> e2.getDateFrom().compareTo(e1.getDateFrom())).toList();
    }
}
