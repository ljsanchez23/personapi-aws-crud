package com.personapi.personapi.adapters.driving.controller;

import com.personapi.personapi.adapters.driving.dto.request.PersonRequest;
import com.personapi.personapi.adapters.driving.dto.response.PersonResponse;
import com.personapi.personapi.adapters.driving.mapper.IPersonRequestMapper;
import com.personapi.personapi.adapters.driving.mapper.IPersonResponseMapper;
import com.personapi.personapi.domain.api.IPersonServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final IPersonRequestMapper personRequestMapper;
    private final IPersonResponseMapper personResponseMapper;
    private final IPersonServicePort personServicePort;

    @PostMapping
    public ResponseEntity<Void> savePerson(@RequestBody PersonRequest personRequest){
        personServicePort.savePerson(personRequestMapper.toModel(personRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonResponse> getPerson(@PathVariable Long personId){
        return ResponseEntity.ok(personResponseMapper.toResponse(personServicePort.getPerson(personId)));
    }
}
