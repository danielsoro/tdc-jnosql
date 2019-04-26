package com.github.danielsoro.models;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

@Entity
public class Person {

    @Id
    private String id;

    @Column
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
