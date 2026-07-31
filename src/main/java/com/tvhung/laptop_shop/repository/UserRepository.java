package com.tvhung.laptop_shop.repository;

import org.springframework.data.repository.CrudRepository;

import com.tvhung.laptop_shop.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    <S extends User> S save(S entity);
}
