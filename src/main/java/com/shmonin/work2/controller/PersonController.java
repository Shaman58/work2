package com.shmonin.work2.controller;

import com.shmonin.work2.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final List<Person> persons = new ArrayList<>();

    {
        persons.add(new Person("john", 20));
        persons.add(new Person("joanna", 24));
        persons.add(new Person("bred", 50));
        persons.add(new Person("kate", 33));
    }

    @GetMapping("/get-by-name")
    public String getPersonByRequestParam(@RequestParam String name) {
        var person = findByName(name);
        return String.format("Person name: %s, age: %s", person.getName(), person.getAge());
    }

    @GetMapping("/get-by-path-name/{name}")
    public String getPersonByPathValue(@PathVariable String name) {
        var person = findByName(name);
        return String.format("Person name: %s, age: %s", person.getName(), person.getAge());
    }

    @PostMapping("/get-by-name-json")
    public String getPersonByRequestBody(@RequestBody String name) {
        var person = findByName(name.split(":")[1].split("\"")[1]);
        return String.format("Person name: %s, age: %s", person.getName(), person.getAge());
    }

    @PostMapping("/add")
    public String addPerson(@RequestParam String name, @RequestParam int age) {
        var person = new Person(name, age);
        persons.add(person);
        return String.format("Person has been added! Person name: %s, age: %s", person.getName(), person.getAge());
    }

    @PostMapping("/{name}")
    public String editPerson(@PathVariable String name, @RequestBody Person person) {
        var targetPerson = findByName(name);
        targetPerson.setName(person.getName());
        targetPerson.setAge(person.getAge());
        return String.format("Person has been edited! Person name: %s, age: %s", targetPerson.getName(), targetPerson.getAge());
    }

    @PostMapping("/delete/{name}")
    public String deletePerson(@PathVariable String name) {
        var person = findByName(name);
        persons.remove(person);
        return String.format("Person has been deleted! Person name: %s, age: %s", person.getName(), person.getAge());
    }

    private Person findByName(String name) {
        return persons.stream().filter(p -> p.getName().equals(name)).findFirst().get();
    }
}
