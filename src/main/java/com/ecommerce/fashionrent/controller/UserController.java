package com.ecommerce.fashionrent.controller;

import com.ecommerce.fashionrent.exception.ResourceNotFoundException;
import com.ecommerce.fashionrent.model.User;
import com.ecommerce.fashionrent.repository.UserRepository;
import com.ecommerce.fashionrent.security.CurrentUser;
import com.ecommerce.fashionrent.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
