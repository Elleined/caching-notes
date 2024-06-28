package com.elleined.caching.service;

import com.elleined.caching.model.Person;

public interface PersonService {
    Person getById(int id);
    Person save(String name);
    void delete(Person person);
    void update(Person person, String name);
}
