package com.elleined.caching.controller;

import com.elleined.caching.dto.CarDTO;
import com.elleined.caching.mapper.CarMapper;
import com.elleined.caching.model.Car;
import com.elleined.caching.model.Person;
import com.elleined.caching.service.car.CarService;
import com.elleined.caching.service.person.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons/{personId}/cars")
public class CarController {
    private final PersonService personService;
    private final CarService carService;
    private final CarMapper carMapper;

    @GetMapping("/{carId}")
    public CarDTO getById(@PathVariable("carId") int carId) {
        Car car = carService.getById(carId);
        return carMapper.toDTO(car);
    }

    @GetMapping
    public Page<CarDTO> getAll(@PathVariable("personId") int personId,
                               @RequestParam(required = false, defaultValue = "1", value = "pageNumber") int pageNumber,
                               @RequestParam(required = false, defaultValue = "5", value = "pageSize") int pageSize,
                               @RequestParam(required = false, defaultValue = "ASC", value = "sortDirection") Sort.Direction direction,
                               @RequestParam(required = false, defaultValue = "id", value = "sortBy") String sortBy) {

        Person person = personService.getById(personId);
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, sortBy);
        return carService.getAll(person, pageable).map(carMapper::toDTO);
    }

    @PostMapping
    public CarDTO save(@PathVariable("personId") int personId,
                       @RequestParam("name") String name) {

        Person person = personService.getById(personId);
        Car car = carService.save(person, name);

        return carMapper.toDTO(car);
    }

    @DeleteMapping("/{carId}")
    public void delete(@PathVariable("personId") int personId,
                       @PathVariable("carId") int carId) {

        Person person = personService.getById(personId);
        Car car = carService.getById(carId);

        carService.delete(person, car);
    }

    @PutMapping("/{carId}")
    public String update(@PathVariable("personId") int personId,
                         @PathVariable("carId") int carId,
                         @RequestParam("name") String name) {

        Person person = personService.getById(personId);
        Car car = carService.getById(carId);

        carService.update(person, car, name);

        return car.getName();
    }
}
