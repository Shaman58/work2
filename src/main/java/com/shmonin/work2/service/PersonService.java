package com.shmonin.work2.service;

import com.shmonin.work2.dto.PersonDto;
import com.shmonin.work2.exception.EntityNotFoundException;
import com.shmonin.work2.model.Person;
import com.shmonin.work2.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PassportService passportService;

    public PersonDto findByName(String name) {
        return toDto(personRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(format("There is no person with name=%s in database", name))));
    }

    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("There is no person with id=%d in database", id)));
    }

    public PersonDto changeAgeById(Long id, int age) {
        var person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("There is no person with id=%d in database", id)));
        person.setAge(age);
        return toDto(personRepository.save(person));
    }

    public void deleteById(Long id) {
        findById(id);
        personRepository.deleteById(id);
    }

    public PersonDto findByNameAndAge(String name, int age) {
        return toDto(personRepository.findByNameAndAge(name, age)
                .orElseThrow(() -> new EntityNotFoundException(format("There is no person with name=%s and age=%d in database", name, age))));
    }

    public List<PersonDto> findAllByAge(int age) {
        return toDto(personRepository.findAllByAge(age));
    }

    public PersonDto save(Person person) {
        var savedPerson = personRepository.save(person);
        return toDto(savedPerson);
    }

    public List<PersonDto> findAllByAgeAfter30() {
        return toDto(personRepository.findAllByAgeAfter30());
    }

    private PersonDto toDto(Person person) {
        var personDto = new PersonDto();
        personDto.setName(person.getName());
        personDto.setSurname(person.getSurname());
        personDto.setAge(person.getAge());
        personDto.setPassport(passportService.toDto(person.getPassport()));
        return personDto;
    }

    public List<PersonDto> toDto(List<Person> people) {
        return people.stream().map(this::toDto).collect(toList());
    }
}
