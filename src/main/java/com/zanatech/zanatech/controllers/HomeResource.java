package com.zanatech.zanatech.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeResource {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
