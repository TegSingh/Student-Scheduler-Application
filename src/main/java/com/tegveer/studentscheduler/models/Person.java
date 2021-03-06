package com.tegveer.studentscheduler.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private List<Todo> todos;

    @Column(name = "password")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Iterable<Todo> getTodosBeforeDate(Date due) {
        ArrayList<Todo> todosBeforeDate = new ArrayList<>();
        for ( Todo todo: this.todos ) {
            if (todo.getDue_date().before(due)) {
                todosBeforeDate.add(todo);
            }
        }
        return todosBeforeDate;
    }
    
    @Override
    public String toString() {
        return "Person ID: " + id +
                " Name: " + name;
    }
}
