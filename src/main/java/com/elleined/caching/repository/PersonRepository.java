package com.elleined.caching.repository;

import com.elleined.caching.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT p FROM Person p")
    Page<Person> getAll(Pageable pageable);
}