package com.tegveer.studentscheduler.models;

import javax.persistence.*;
import java.util.Date;

// This is an entity in the underlying PostgreSQL database
@Entity
@Table(name="todo")
public class Todo {

    // Primary key in Todo
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="due_date")
    private Date due_date;

    @Column(name="date_added")
    private Date date_added;

    @Column(name = "person_id")
    private Integer person_id;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "Todo: " + name + " due at: " + due_date.toString() +
                " added at: " + date_added.toString();
    }
}
