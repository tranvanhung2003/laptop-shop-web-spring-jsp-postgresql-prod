package com.tvhung.laptop_shop.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tvhung.laptop_shop.domain.Role;
import com.tvhung.laptop_shop.domain.User;
import com.tvhung.laptop_shop.enums.FileType;
import com.tvhung.laptop_shop.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

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

    public User saveUser(User user, MultipartFile avatarFile) {
        Role role = roleService.getRoleByName(user.getRole().getName());
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        String avatar = uploadService.saveUploadFile(avatarFile, FileType.AVATAR);

        user.setRole(role);
        user.setPassword(hashedPassword);
        if (avatar != null) {
            user.setAvatar(avatar);
        }

        return userRepository.save(user);
    }

    public User updateUser(long id, User updateUser) {
        User existingUser = getUserById(id);
        existingUser.updateFrom(updateUser);

        return saveUser(existingUser, null);
    }

    public void deleteUser(long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
