package com.elleined.caching.service.car;

import com.elleined.caching.model.Car;
import com.elleined.caching.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Car getById(int id);
    Page<Car> getAll(Pageable pageable);
    Car save(String name, Person person);
    void delete(Car car);
    void update(Car car, String name);
}
