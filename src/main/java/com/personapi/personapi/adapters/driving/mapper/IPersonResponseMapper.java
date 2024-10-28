package com.personapi.personapi.adapters.driving.mapper;

import com.personapi.personapi.adapters.driving.dto.response.PersonResponse;
import com.personapi.personapi.domain.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPersonResponseMapper {
    @Mapping(source = "person.name", target = "name")
    @Mapping(source = "person.idDocument", target = "idDocument")
    @Mapping(source = "person.email", target = "email")
    PersonResponse toResponse(Person person);
}
