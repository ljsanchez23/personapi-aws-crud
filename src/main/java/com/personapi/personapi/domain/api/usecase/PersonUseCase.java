package com.personapi.personapi.domain.api.usecase;

import com.personapi.personapi.domain.api.IPersonServicePort;
import com.personapi.personapi.domain.exception.PersonNotFoundException;
import com.personapi.personapi.domain.model.Person;
import com.personapi.personapi.domain.spi.IPersonPersistencePort;
import com.personapi.personapi.domain.util.Constants;

public class PersonUseCase implements IPersonServicePort {
    private final IPersonPersistencePort personPersistencePort;

    public PersonUseCase(IPersonPersistencePort personPersistencePort) {
        this.personPersistencePort = personPersistencePort;
    }

    @Override
    public void savePerson(Person person) {
        personPersistencePort.savePerson(person);
    }

    @Override
    public Person getPerson(Long personId) {
        return personPersistencePort.getPerson(personId)
                .orElseThrow(() -> new PersonNotFoundException(Constants.PERSON_NOT_FOUND_ERROR_MESSAGE));
    }
}
