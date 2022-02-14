package com.tegveer.studentscheduler.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="todo")
public class Todo {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="due_date")
    private Date due_date;

    @Column(name="date_added")
    private Date date_added;

    // Many To-dos for one person
    @ManyToOne
    // The column in this table that is being used to reference the primary key in person is person_id
    @JoinColumn(name = "person_id")
    private Person person;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
