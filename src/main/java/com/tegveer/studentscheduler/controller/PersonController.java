package com.tegveer.studentscheduler.controller;

import com.tegveer.studentscheduler.models.Person;
import com.tegveer.studentscheduler.models.Todo;
import com.tegveer.studentscheduler.repository.PersonRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

// This class will control all CRUD as well as some custom operations for todos
@RequestMapping("api/person")
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
public class PersonController {

    // Link the repository to the controller
    private final PersonRepository personRepository;
    // Constructor
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // READ - Get all people URL: api/person
    @GetMapping
    public Iterable<Person> getAllPeople() {
        System.out.println("Getting all People in the database");
        return this.personRepository.findAll();
    }

    // READ - Get Person by Id URL: api/person/id
    @GetMapping(path = "/{id}")
    public Optional<Person> getPersonById(@PathVariable Integer id) {
        System.out.println("Get person by ID: " + id);
        return this.personRepository.findById(id);
    }

    // READ - Get Todos for a person URL: api/person/id/todos
    @GetMapping(path = "/{id}/todos")
    public Iterable<Todo> getTodosForPerson(@PathVariable Integer id) {
        System.out.println("Getting Todos for Person with ID: " + id);
        Optional<Person> personOptional = this.personRepository.findById(id);
        if (!personOptional.isPresent()) {
            System.out.println("Person not found");
            return null;
        } else {
            Person personChoice = personOptional.get();
            return personChoice.getTodos();
        }
    }

    // READ - Get Todos for a person before a date
    @GetMapping(path = "/{id}/todos/date")
    public Iterable<Todo> getTodosBeforeDate(@PathVariable Integer id, @RequestParam(name = "due_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date due_date) {
        System.out.println("Getting Todos before date: " + due_date.toString() + " for Person ID: " + id);
        Optional<Person> personOptional = this.personRepository.findById(id);
        if (!personOptional.isPresent()) {
            System.out.println("Person not found");
            return null;
        } else {
            Person personChoice = personOptional.get();
            return personChoice.getTodosBeforeDate(due_date);
        }
    }

    // READ - Login for user
    @GetMapping(path = "/login")
    public Person loginUser(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        System.out.println("Logging User In with Email: " + email);
        ArrayList<Person> users = (ArrayList<Person>) this.personRepository.findAll();
        for (Person person : users) {
            System.out.println(person.toString());
            if (person.getEmail().equals(email)) {
                if (person.getPassword().equals(password)) {
                    System.out.println("Login successful");
                    return person;
                } else {
                    System.out.println("Wrong password");
                    return null;
                }
             }
        }
        System.out.println("Person Not found");
        return null;
    }

    // CREATE - POST Request URL api/person
    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        System.out.println("Adding New Person: " + person.toString());
        return this.personRepository.save(person);
    }

    // POST - Request to register new user
    @PostMapping(path = "/register")
    public Person registerUser(@RequestParam(name = "name") String name, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        System.out.println("Registering New Person with Name: " + name);
        Person person = new Person();
        person.setName(name);
        person.setEmail(email);
        person.setPassword(password);
        return this.personRepository.save(person);
    }

    // UPDATE - Put request URL: api/person/id
    @PutMapping(path = "/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable Integer id) {
        System.out.println("Update person with ID: " + id);
        Optional<Person> personToUpdateOptional = this.personRepository.findById(id);
        if (personToUpdateOptional.isPresent()) {
            // Get the person associated with requested ID
            Person personUpdate = personToUpdateOptional.get();
            if (person.getName() != null) {
                personUpdate.setName(person.getName());
            }
            if (person.getEmail() != null) {
                personUpdate.setEmail(person.getEmail());
            }
            if (person.getPassword() != null) {
                personUpdate.setPassword(person.getPassword());
            }
            return this.personRepository.save(personUpdate);
        } else {
            System.out.println("Could not locate person");
            return null;
        }
    }

    // DELETE URL: api/person/id
    @DeleteMapping(path = "/{id}")
    public Person deletePerson(@PathVariable Integer id) {
        Optional<Person> personToDelete = this.personRepository.findById(id);
        if (personToDelete.isPresent()) {
            this.personRepository.delete(personToDelete.get());
            return personToDelete.get();
        } else {
            System.out.println("Person does not exist");
            return null;
        }
    }
}
