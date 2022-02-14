package com.tegveer.studentscheduler.repository;

import com.tegveer.studentscheduler.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
