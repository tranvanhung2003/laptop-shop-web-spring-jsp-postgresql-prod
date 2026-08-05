package com.tvhung.laptop_shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tvhung.laptop_shop.domain.User;
import com.tvhung.laptop_shop.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "User not found with id: %d".formatted(id)));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllUsersByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(long id, User updateUser) {
        User existingUser = getUserById(id);
        existingUser.updateFrom(updateUser);
        return saveUser(existingUser);
    }

    public void deleteUser(long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
