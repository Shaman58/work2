package com.shmonin.work2.service;

import com.shmonin.work2.exception.EntityNotFoundException;
import com.shmonin.work2.model.Person;
import com.shmonin.work2.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person getByName(String name) {
        return personRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(format("There is no person with name=%s in database", name)));
    }

    @Override
    public Person changeAgeById(Long id, int age) {
        var person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("There is no person with id=%d in database", id)));
        person.setAge(age);
        return personRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("There is no person with id=%d in database", id)));
        personRepository.deleteById(id);
    }

    @Override
    public Person getByNameAndAge(String name, int age) {
        return personRepository.findByNameAndAge(name, age)
                .orElseThrow(() -> new EntityNotFoundException(format("There is no person with name=%s and age=%d in database", name, age)));
    }

    @Override
    public List<Person> getAllByAge(int age) {
        return personRepository.findAllByAge(age);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllByAgeAfter30() {
        return personRepository.findAllByAgeAfter30();
    }
}
