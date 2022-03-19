package com.shmonin.work2.repository;

import com.shmonin.work2.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByName(String name);

    Optional<Person> findByNameAndAge(String name, int age);

    List<Person> findAllByAge(int age);

    @Query("SELECT p FROM Person p WHERE p.age>30")
    List<Person> findAllByAgeAfter30();
}
