package com.ecommerce.fashionrent.repository;

import com.ecommerce.fashionrent.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

    Optional<UserDetail> findByUserId(Long userId);
}
