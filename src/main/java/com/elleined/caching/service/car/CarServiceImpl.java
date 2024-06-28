package com.elleined.caching.service.car;

import com.elleined.caching.exception.resource.ResourceNotFoundException;
import com.elleined.caching.mapper.CarMapper;
import com.elleined.caching.model.Car;
import com.elleined.caching.model.Person;
import com.elleined.caching.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public Car getById(int id) {
        return carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car with id of " + id + " doesn't exists"));
    }

    @Override
    public Page<Car> getAll(Pageable pageable) {
        return carRepository.getAll(pageable);
    }

    @Override
    public Car save(String name, Person person) {
        Car car = carMapper.toEntity(name, person);

        carRepository.save(car);
        log.debug("Saving car success");
        return car;
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
        log.debug("Deleting car success");
    }

    @Override
    public void update(Car car, String name) {
        car.setName(name);

        carRepository.save(car);
        log.debug("Updating car success");
    }
}
