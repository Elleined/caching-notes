package com.elleined.caching.service.person;

import com.elleined.caching.exception.resource.ResourceNotFoundException;
import com.elleined.caching.mapper.PersonMapper;
import com.elleined.caching.model.Person;
import com.elleined.caching.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public Person getById(int id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person with id of " + id + " doesn't exists"));
    }

    @Override
    public Page<Person> getAll(Pageable pageable) {
        return personRepository.getAll(pageable);
    }

    @Override
    public Person save(String name) {
        Person person = personMapper.toEntity(name);

        personRepository.save(person);
        log.debug("Saving person success");
        return person;
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
        log.debug("Deleting person success");
    }

    @Override
    public void update(Person person, String name) {
        person.setName(name);

        personRepository.save(person);
        log.debug("Updating person success");
    }
}
