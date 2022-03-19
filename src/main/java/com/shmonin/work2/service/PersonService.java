package com.shmonin.work2.service;

import com.shmonin.work2.model.Person;

import java.util.List;

public interface PersonService {

    Person getByName(String name);

    Person changeAgeById(Long id, int age);

    void deleteById(Long id);

    Person getByNameAndAge(String name, int age);

    List<Person> getAllByAge(int age);

    Person save(Person person);

    List<Person> getAllByAgeAfter30();
}
