package com.elleined.caching.populator;

import com.elleined.caching.mapper.PersonMapper;
import com.elleined.caching.model.Person;
import com.elleined.caching.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PersonPopulator implements Populator {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    private final Faker faker;

    @Override
    public void populate() {
        Person person1 = personMapper.toEntity(faker.name().fullName());
        Person person2 = personMapper.toEntity(faker.name().fullName());
        Person person3 = personMapper.toEntity(faker.name().fullName());
        Person person4 = personMapper.toEntity(faker.name().fullName());

        List<Person> persons = List.of(person1, person2, person3, person4);
        personRepository.saveAll(persons);
    }
}
