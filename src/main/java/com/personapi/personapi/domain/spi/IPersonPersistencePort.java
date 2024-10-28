package com.personapi.personapi.domain.spi;

import com.personapi.personapi.domain.model.Person;

import java.util.Optional;

public interface IPersonPersistencePort {
    void savePerson(Person person);
    Optional<Person> getPerson(Long personId);
}
