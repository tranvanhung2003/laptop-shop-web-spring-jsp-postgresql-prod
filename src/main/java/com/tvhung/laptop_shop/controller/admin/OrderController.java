package com.tvhung.laptop_shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/order")
public class OrderController {
    @GetMapping
    public String getOrderPage() {
        return "admin/order/index";
    }
}
