package com.personapi.personapi.adapters.driven.aws;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personapi.personapi.adapters.driven.aws.util.DatabaseCredentials;
import com.personapi.personapi.adapters.exception.DatabaseCredentialsException;
import com.personapi.personapi.adapters.util.AdaptersConstants;
import org.springframework.stereotype.Service;

@Service
public class DatabaseCredentialsService {

    private final SecretsManagerService secretsManagerService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public DatabaseCredentialsService(SecretsManagerService secretsManagerService) {
        this.secretsManagerService = secretsManagerService;
    }

    public DatabaseCredentials getDatabaseCredentials() {
        try {
            String secretName = System.getenv(AdaptersConstants.SECRET_NAME);

            String secretString = secretsManagerService.getSecret(secretName);
            JsonNode jsonNode = objectMapper.readTree(secretString);
            return new DatabaseCredentials(
                    jsonNode.get(AdaptersConstants.USERNAME_FROM_SECRET).asText(),
                    jsonNode.get(AdaptersConstants.PASSWORD_FROM_SECRET).asText(),
                    jsonNode.get(AdaptersConstants.HOST_FROM_SECRET).asText(),
                    jsonNode.get(AdaptersConstants.PORT_FROM_SECRET).asText(),
                    jsonNode.get(AdaptersConstants.DB_NAME_FROM_SECRET).asText()
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseCredentialsException(AdaptersConstants.PROBLEM_CONNECTING_WITH_RDS_DATABASE);
        }
    }
}