package com.ecommerce.fashionrent.controller;

import com.ecommerce.fashionrent.dto.ProductDto;
import com.ecommerce.fashionrent.dto.UserDetailDto;
import com.ecommerce.fashionrent.dto.mapper.UserDetailMapper;
import com.ecommerce.fashionrent.entity.UserDetail;
import com.ecommerce.fashionrent.exception.ResourceNotFoundException;
import com.ecommerce.fashionrent.model.User;
import com.ecommerce.fashionrent.repository.UserDetailRepository;
import com.ecommerce.fashionrent.repository.UserRepository;
import com.ecommerce.fashionrent.security.CurrentUser;
import com.ecommerce.fashionrent.security.UserPrincipal;
import com.ecommerce.fashionrent.service.AuthService;
import com.ecommerce.fashionrent.service.UserService;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private UserService userservice;

    @Autowired
    private AuthService authService;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser() {
        UserPrincipal userPrincipal = authService.getUserPrincipal();
        User user = new User();
        user.setId(userPrincipal.getId());
        user.setFirstName(userPrincipal.getFirstName());
        user.setLastName(userPrincipal.getLastName());
        user.setEmail(userPrincipal.getEmail());
        return user;

    }

    @PostMapping("/user/details")
    public UserDetailDto saveUserDetails(@RequestBody UserDetailDto userDetailDto) {
        UserPrincipal userPrincipal = authService.getUserPrincipal();
        UserDetail userDetail = UserDetailMapper.MAPPER.userDetailDtoToUserDetail(userDetailDto);
        userDetail.setUserId(userPrincipal.getId());
        UserDetail savedUser = userDetailRepository.save(userDetail);
        return UserDetailMapper.MAPPER.userDetailToUserDetailDto(savedUser);
    }

    @PostMapping(
            path = "/saveImage",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDetailDto> saveUserImage(
                                                  @RequestParam("file") MultipartFile files) throws IOException {
        UserPrincipal userPrincipal = authService.getUserPrincipal();
        Integer userId = Math.toIntExact(userPrincipal.getId());
        UserDetail userDetail = userservice.saveUserImage(userId,files);
        return new ResponseEntity<UserDetailDto>(UserDetailMapper.MAPPER.userDetailToUserDetailDto(userDetail), HttpStatus.OK);
    }


}
