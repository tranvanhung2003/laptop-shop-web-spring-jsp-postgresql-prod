package com.tvhung.laptop_shop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tvhung.laptop_shop.domain.User;
import com.tvhung.laptop_shop.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getUserPage(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "admin/user/index";
    }

    @GetMapping("/{id}")
    public String getUserDetailPage(Model model, @PathVariable("id") long id) {
        model.addAttribute("id", id);
        User user = userService.getUserById(id);
        model.addAttribute("user", user);

        return "admin/user/detail";
    }

    @GetMapping("/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("createUser", new User());

        return "admin/user/create";
    }

    @PostMapping
    public String createUser(Model model, @ModelAttribute("createUser") User createUser) {
        userService.saveUser(createUser);

        return "redirect:/admin/user";
    }

    @GetMapping("/{id}/edit")
    public String getEditUserPage(Model model, @PathVariable("id") long id) {
        model.addAttribute("id", id);
        User user = userService.getUserById(id);
        model.addAttribute("editUser", user);

        return "admin/user/edit";
    }

    @PostMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable long id, @ModelAttribute("editUser") User editUser) {
        userService.updateUser(id, editUser);

        return "redirect:/admin/user";
    }

    @GetMapping("/{id}/delete")
    public String getDeleteUserPage(Model model, @PathVariable("id") long id) {
        model.addAttribute("id", id);

        return "admin/user/delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(Model model, @PathVariable("id") long id) {
        userService.deleteUser(id);

        return "redirect:/admin/user";
    }
}
