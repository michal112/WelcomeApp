package com.example.welcomeapp.service;

import com.example.welcomeapp.controller.PersonController;
import com.example.welcomeapp.entity.PersonEntity;
import com.example.welcomeapp.payload.PersonPayload;
import com.example.welcomeapp.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<PersonPayload> get() {
        return personRepository.findAll().stream()
                .map(it -> new PersonPayload(it.getPublicId(), it.getName()))
                .collect(Collectors.toList());
    }

    public PersonPayload create(PersonPayload personPayload) {
        var personEntity = new PersonEntity();
        personEntity.setPublicId(UUID.randomUUID().toString());
        personEntity.setName(personPayload.getName());
        personRepository.save(personEntity);

        return new PersonPayload(personEntity.getPublicId(), personEntity.getName());
    }
}
