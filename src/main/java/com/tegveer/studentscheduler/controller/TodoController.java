package com.tegveer.studentscheduler.controller;

import com.tegveer.studentscheduler.models.Todo;
import com.tegveer.studentscheduler.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// This class will control all crud operations for todos
@RequestMapping("api/todo")
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
public class TodoController {

    // Connect the repository to the controller
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public Iterable<Todo> getAllTodos() {
        return this.todoRepository.findAll();
    }

    // READ
    @GetMapping(path = "/{id}")
    public Optional<Todo> getTodoById(@PathVariable Integer id) {
        System.out.println("Get Todo by ID: " + id);
        return this.todoRepository.findById(id);
    }

    // CREATE
    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        System.out.println("Adding New Todo: " + todo.toString());
        return this.todoRepository.save(todo);
    }

    // UPDATE
    @PutMapping(path = "/{id}")
    public Todo todoUpdate(@RequestBody Todo todo, @PathVariable Integer id) {
        System.out.println("Update Todo with ID: " + id);
        Optional<Todo> todoToUpdateOptional = this.todoRepository.findById(id);
        if (todoToUpdateOptional.isPresent()) {
            // Get the todo associated with requested ID
            Todo todoUpdate = todoToUpdateOptional.get();
            if (todo.getName() != null) {
                todoUpdate.setName(todo.getName());
            }
            if (todo.getDue_date() != null) {
                todoUpdate.setDue_date(todo.getDue_date());
            }
            if (todo.getDate_added() != null) {
                todoUpdate.setDate_added(todo.getDate_added());
            }
            if (todo.getPerson_id() != null) {
                todoUpdate.setPerson_id(todo.getPerson_id());
            }
            return this.todoRepository.save(todoUpdate);
        } else {
            System.out.println("Could not locate Todo");
            return null;
        }
    }

    // DELETE
    @DeleteMapping(path = "/{id}")
    public Todo deleteTodo(@PathVariable Integer id) {
        Optional<Todo> todoToDelete = this.todoRepository.findById(id);
        if (todoToDelete.isPresent()) {
            this.todoRepository.delete(todoToDelete.get());
            return todoToDelete.get();
        } else {
            System.out.println("Todo item does not exist");
            return null;
        }
    }
}
