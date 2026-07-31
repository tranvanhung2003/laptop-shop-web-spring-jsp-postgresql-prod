package com.tvhung.laptop_shop.service;

import org.springframework.stereotype.Service;

import com.tvhung.laptop_shop.domain.User;
import com.tvhung.laptop_shop.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public <S extends User> S saveUser(S entity) {
        return userRepository.save(entity);
    }
}
