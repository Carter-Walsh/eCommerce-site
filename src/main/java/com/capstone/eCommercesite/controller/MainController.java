package com.capstone.eCommercesite.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @PostMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/homepage")
    public String homepage() {
        return "homepage";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        return "one product";
    }

}
