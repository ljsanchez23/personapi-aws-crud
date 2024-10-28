package com.personapi.personapi.adapters.driven.jpa.mysql.adapter;

import com.personapi.personapi.adapters.driven.jpa.mysql.mapper.IPersonEntityMapper;
import com.personapi.personapi.adapters.driven.jpa.mysql.repository.IPersonRepository;
import com.personapi.personapi.domain.model.Person;
import com.personapi.personapi.domain.spi.IPersonPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class PersonAdapter implements IPersonPersistencePort {
    private final IPersonRepository personRepository;
    private final IPersonEntityMapper personEntityMapper;

    @Override
    public void savePerson(Person person) {
        personRepository.save(personEntityMapper.toEntity(person));
    }

    @Override
    public Optional<Person> getPerson(Long personId) {
        return personRepository.findById(personId)
                .map(personEntityMapper::toModel);
    }
}
