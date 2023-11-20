package com.ecommerce.fashionrent.controller;

import com.ecommerce.fashionrent.exception.ResourceNotFoundException;
import com.ecommerce.fashionrent.model.User;
import com.ecommerce.fashionrent.repository.UserRepository;
import com.ecommerce.fashionrent.security.CurrentUser;
import com.ecommerce.fashionrent.security.UserPrincipal;
import com.ecommerce.fashionrent.service.AuthService;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

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
}
