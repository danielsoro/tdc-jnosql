package com.github.danielsoro.services;

import com.github.danielsoro.models.Person;
import org.jnosql.artemis.Repository;

import java.util.List;

public interface PersonRepository extends Repository<Person, String> {
    List<Person> findAll();
}
