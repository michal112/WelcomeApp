package com.example.welcomeapp.controller;

import com.example.welcomeapp.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/welcome")
@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService welcomeService;

    @GetMapping
    public String welcome() {
        return welcomeService.welcome();
    }
}
