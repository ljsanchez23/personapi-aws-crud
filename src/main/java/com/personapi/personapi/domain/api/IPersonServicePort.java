package com.personapi.personapi.domain.api;

import com.personapi.personapi.domain.model.Person;

public interface IPersonServicePort {
    void savePerson(Person person);
    Person getPerson(Long personId);
}
