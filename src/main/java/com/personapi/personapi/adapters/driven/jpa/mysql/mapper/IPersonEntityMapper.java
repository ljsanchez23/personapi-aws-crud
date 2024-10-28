package com.personapi.personapi.adapters.driven.jpa.mysql.mapper;

import com.personapi.personapi.adapters.driven.jpa.mysql.entity.PersonEntity;
import com.personapi.personapi.domain.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPersonEntityMapper {
    @Mapping(source = "person.name", target = "name")
    @Mapping(source = "person.idDocument", target = "idDocument")
    @Mapping(source = "person.email", target = "email")
    @Mapping(target = "id", ignore = true)
    PersonEntity toEntity(Person person);
    @Mapping(source = "personEntity.name", target = "name")
    @Mapping(source = "personEntity.idDocument", target = "idDocument")
    @Mapping(source = "personEntity.email", target = "email")
    Person toModel(PersonEntity personEntity);
}
