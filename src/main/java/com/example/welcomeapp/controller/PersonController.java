package com.example.welcomeapp.controller;

import com.example.welcomeapp.payload.PersonPayload;
import com.example.welcomeapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonPayload> get() {
        return personService.get();
    }

    @PostMapping
    public PersonPayload create(@RequestBody PersonPayload personPayload) {
        return personService.create(personPayload);
    }
}
