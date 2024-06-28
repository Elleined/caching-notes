package com.elleined.caching.service;

import com.elleined.caching.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {
    Person getById(int id);
    Page<Person> getAll(Pageable pageable);
    Person save(String name);
    void delete(Person person);
    void update(Person person, String name);
}
