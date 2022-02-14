package com.tegveer.studentscheduler.controller;

import com.tegveer.studentscheduler.models.Todo;
import com.tegveer.studentscheduler.repository.TodoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This class will control all crud operations for todos
@RequestMapping("api/todo")
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
}
