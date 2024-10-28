package com.personapi.personapi.adapters.driven.aws.util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DatabaseCredentials {
    private String username;
    private String password;
    private String host;
    private String port;
    private String dbName;
}
