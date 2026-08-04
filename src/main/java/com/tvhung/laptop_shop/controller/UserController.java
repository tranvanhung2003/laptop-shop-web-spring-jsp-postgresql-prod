package com.tvhung.laptop_shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tvhung.laptop_shop.domain.User;
import com.tvhung.laptop_shop.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "admin/user/index";
    }

    @GetMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);

        return "admin/user/detail";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());

        return "admin/user/create";
    }

    @PostMapping("/admin/user/create")
    public String createUserPage(Model model, @ModelAttribute("newUser") User user) {
        userService.saveUser(user);

        return "redirect:/admin/user";
    }
}
