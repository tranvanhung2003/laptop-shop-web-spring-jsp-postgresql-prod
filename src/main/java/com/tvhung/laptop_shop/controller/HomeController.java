package com.tvhung.laptop_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("test", "My Home Page");

        return "hello";
    }
}
