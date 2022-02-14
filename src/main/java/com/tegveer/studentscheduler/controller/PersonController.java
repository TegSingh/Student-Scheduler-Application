package com.tegveer.studentscheduler.controller;

import com.tegveer.studentscheduler.models.Person;
import com.tegveer.studentscheduler.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// This class will control all CRUD as well as some custom operations for todos
@RequestMapping("api/person")
@RestController
public class PersonController {

    // Link the repository to the controller
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Iterable<Person> getAllPeople() {
        System.out.println(this.personRepository.findAll());
        return this.personRepository.findAll();
    }
}
