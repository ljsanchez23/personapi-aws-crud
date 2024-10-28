package com.personapi.personapi.adapters.driving.mapper;

import com.personapi.personapi.adapters.driving.dto.request.PersonRequest;
import com.personapi.personapi.domain.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPersonRequestMapper {
    @Mapping(source = "personRequest.name", target = "name")
    @Mapping(source = "personRequest.idDocument", target = "idDocument")
    @Mapping(source = "personRequest.email", target = "email")
    Person toModel(PersonRequest personRequest);
}
