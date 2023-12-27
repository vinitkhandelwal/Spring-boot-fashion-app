package com.ecommerce.fashionrent.dto.mapper;

import com.amazonaws.services.securityhub.model.Product;
import com.ecommerce.fashionrent.dto.ProductDto;
import com.ecommerce.fashionrent.entity.ProductLenders;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductLenders productDtoToProductLender(ProductDto productDto);

    ProductDto productLendersToProductDto(ProductLenders productLenders);

}
