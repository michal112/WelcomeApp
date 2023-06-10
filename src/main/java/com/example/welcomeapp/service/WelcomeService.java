package com.example.welcomeapp.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    public String welcome() {
        return "hello world";
    }
}
