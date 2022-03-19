package com.shmonin.work2.mapper;

import com.shmonin.work2.dto.PersonDto;
import com.shmonin.work2.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class PersonMapper {

    public PersonDto toDto(Person person) {
        var personDto = new PersonDto();
        personDto.setName(person.getName());
        personDto.setSurname(person.getSurname());
        personDto.setAge(person.getAge());
        personDto.setPatronymic(person.getPatronymic());
        return personDto;
    }

    public List<PersonDto> toDto(List<Person> people) {
        return people.stream().map(this::toDto).collect(toList());
    }
}
