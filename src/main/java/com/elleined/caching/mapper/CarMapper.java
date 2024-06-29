package com.elleined.caching.mapper;

import com.elleined.caching.dto.CarDTO;
import com.elleined.caching.model.Car;
import com.elleined.caching.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "personId", source = "person.id")
    })
    CarDTO toDTO(Car car);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "person", source = "person")
    })
    Car toEntity(String name, Person person);
}
