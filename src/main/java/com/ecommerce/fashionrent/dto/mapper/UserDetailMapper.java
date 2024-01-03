package com.ecommerce.fashionrent.dto.mapper;

import com.ecommerce.fashionrent.dto.ProductDto;
import com.ecommerce.fashionrent.dto.UserDetailDto;
import com.ecommerce.fashionrent.entity.ProductLenders;
import com.ecommerce.fashionrent.entity.UserDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDetailMapper {
    UserDetailMapper MAPPER = Mappers.getMapper(UserDetailMapper.class);

    UserDetail userDetailDtoToUserDetail(UserDetailDto userDetailDto);

    UserDetailDto userDetailToUserDetailDto(UserDetail userDetail);

}
