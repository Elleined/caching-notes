package com.elleined.caching.controller;

import com.elleined.caching.dto.PersonDTO;
import com.elleined.caching.mapper.PersonMapper;
import com.elleined.caching.model.Person;
import com.elleined.caching.service.person.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;
    private final PersonMapper personMapper;

    @GetMapping("/{personId}")
    public PersonDTO getById(@PathVariable("personId") int personId) {
        Person person = personService.getById(personId);
        return personMapper.toDTO(person);
    }

    @GetMapping
    public Page<PersonDTO> getAll(@RequestParam(required = false, defaultValue = "1", value = "pageNumber") int pageNumber,
                                  @RequestParam(required = false, defaultValue = "5", value = "pageSize") int pageSize,
                                  @RequestParam(required = false, defaultValue = "ASC", value = "sortDirection") Sort.Direction direction,
                                  @RequestParam(required = false, defaultValue = "id", value = "sortBy") String sortBy) {

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, sortBy);
        return personService.getAll(pageable).map(personMapper::toDTO);
    }

    @PostMapping
    public PersonDTO save(@RequestParam("name") String name) {
        Person person = personService.save(name);
        return personMapper.toDTO(person);
    }

    @DeleteMapping("/{personId}")
    public void delete(@PathVariable("personId") int personId) {
        Person person = personService.getById(personId);
        personService.delete(person);
    }

    @PutMapping("/{personId}")
    public void update(@PathVariable("personId") int personId,
                       @RequestParam("name") String name) {

        Person person = personService.getById(personId);
        personService.update(person, name);
    }
}
