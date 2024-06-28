package com.elleined.caching.mapper;

import com.elleined.caching.dto.PersonDTO;
import com.elleined.caching.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.cache.annotation.Cacheable;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "carIds", expression = "java(person.carIds())")
    })
    PersonDTO toDTO(Person person);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "cars", expression = "java(new java.util.ArrayList<>())")
    })
    Person toEntity(String name);
}
