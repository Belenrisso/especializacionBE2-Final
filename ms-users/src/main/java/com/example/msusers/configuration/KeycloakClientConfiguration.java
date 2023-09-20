package com.example.msusers.configuration;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakClientConfiguration {

    @Bean
    public Keycloak getInstance() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080/")
                .realm("parcial")
                .clientId("users-client")
                .clientSecret("BYOBiiaCnflXpmPskDJLTlqiAssHjCzH")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }

}
