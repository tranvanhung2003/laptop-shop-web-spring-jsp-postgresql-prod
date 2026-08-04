package com.tvhung.laptop_shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvhung.laptop_shop.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);
}
