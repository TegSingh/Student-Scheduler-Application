package com.tegveer.studentscheduler.repository;

import com.tegveer.studentscheduler.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
