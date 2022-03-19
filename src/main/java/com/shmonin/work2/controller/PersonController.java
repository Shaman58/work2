package com.shmonin.work2.controller;

import com.shmonin.work2.dto.PersonDto;
import com.shmonin.work2.mapper.PersonMapper;
import com.shmonin.work2.model.Person;
import com.shmonin.work2.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final PersonMapper personMapper;

    @GetMapping("/person")
    public Person getByName(@RequestParam String name) {
        return personService.getByName(name);
    }

    @PutMapping("/person/{id}")
    public Person changeAgeById(@PathVariable Long id, @RequestParam int age) {
        return personService.changeAgeById(id, age);
    }

    @DeleteMapping("/person/{id}")
    public void deleteById(@PathVariable Long id) {
        personService.deleteById(id);
    }

    @GetMapping("/person/{name}/{age}")
    public Person getByNameAndAge(@PathVariable String name, @PathVariable int age) {
        return personService.getByNameAndAge(name, age);
    }

    @GetMapping("/persons")
    public List<Person> getAllByAge(@RequestParam int age) {
        return personService.getAllByAge(age);
    }

    @PutMapping("/person")
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/persons/after30")
    public List<PersonDto> getAllByAgeAfter() {
        return personMapper.toDto(personService.getAllByAgeAfter30());
    }
}
