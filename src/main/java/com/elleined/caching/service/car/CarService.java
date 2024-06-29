package com.elleined.caching.service.car;

import com.elleined.caching.model.Car;
import com.elleined.caching.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Car getById(int id);
    Page<Car> getAll(Person person, Pageable pageable);
    Car save(Person person, String name);
    void delete(Person person, Car car);
    void update(Person person, Car car, String name);
}
