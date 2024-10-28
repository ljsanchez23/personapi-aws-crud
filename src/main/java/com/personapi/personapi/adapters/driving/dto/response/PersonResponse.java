package com.personapi.personapi.adapters.driving.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonResponse {
    private String name;
    private Integer idDocument;
    private String email;
}
