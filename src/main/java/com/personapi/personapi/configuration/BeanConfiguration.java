package com.personapi.personapi.configuration;

import com.personapi.personapi.adapters.driven.jpa.mysql.adapter.PersonAdapter;
import com.personapi.personapi.adapters.driven.jpa.mysql.mapper.IPersonEntityMapper;
import com.personapi.personapi.adapters.driven.jpa.mysql.repository.IPersonRepository;
import com.personapi.personapi.domain.api.IPersonServicePort;
import com.personapi.personapi.domain.api.usecase.PersonUseCase;
import com.personapi.personapi.domain.spi.IPersonPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IPersonRepository personRepository;
    private final IPersonEntityMapper personEntityMapper;

    @Bean
    public IPersonPersistencePort personPersistencePort(){
        return new PersonAdapter(personRepository, personEntityMapper);
    }

    @Bean
    public IPersonServicePort personServicePort(){
        return new PersonUseCase(personPersistencePort());
    }
}
