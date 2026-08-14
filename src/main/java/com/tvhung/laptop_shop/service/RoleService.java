package com.tvhung.laptop_shop.service;

import org.springframework.stereotype.Service;

import com.tvhung.laptop_shop.domain.Role;
import com.tvhung.laptop_shop.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getRoleByName(String name) {
        return roleRepository.findByName(name).orElseThrow(
                () -> new RuntimeException("Role not found with name: %s".formatted(name)));
    }
}
