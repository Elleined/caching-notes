package com.elleined.caching.repository;

import com.elleined.caching.model.Car;
import com.elleined.caching.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT c FROM Car c")
    Page<Car> getAll(Pageable pageable);
}