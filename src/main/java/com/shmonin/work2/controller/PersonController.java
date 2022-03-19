package com.shmonin.work2.controller;

import com.shmonin.work2.dto.PersonDto;
import com.shmonin.work2.model.Person;
import com.shmonin.work2.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/person")
    public PersonDto findByName(@RequestParam String name) {
        return personService.findByName(name);
    }

    @PutMapping("/person/{id}")
    public PersonDto changeAgeById(@PathVariable Long id, @RequestParam int age) {
        return personService.changeAgeById(id, age);
    }

    @DeleteMapping("/person/{id}")
    public void deleteById(@PathVariable Long id) {
        personService.deleteById(id);
    }

    @GetMapping("/person/{name}/{age}")
    public PersonDto findByNameAndAge(@PathVariable String name, @PathVariable int age) {
        return personService.findByNameAndAge(name, age);
    }

    @GetMapping("/persons")
    public List<PersonDto> findAllByAge(@RequestParam int age) {
        return personService.findAllByAge(age);
    }

    @PutMapping("/person")
    public PersonDto save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/persons/after30")
    public List<PersonDto> findAllByAgeAfter() {
        return personService.findAllByAgeAfter30();
    }
}
