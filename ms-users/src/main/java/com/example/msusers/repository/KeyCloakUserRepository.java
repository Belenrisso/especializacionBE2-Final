package com.example.msusers.repository;

import com.example.msusers.domain.Bill;
import com.example.msusers.domain.User;
import lombok.AllArgsConstructor;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Repository
public class KeyCloakUserRepository implements IUserRepository {
    private BillRepository billRepository;
    private final Keycloak keycloak;

    public KeyCloakUserRepository() {
        this.keycloak = KeycloakBuilder.builder().
                serverUrl("http://localhost:8080/")
                .realm("parcial")
                .clientId("users-client")
                .clientSecret("BYOBiiaCnflXpmPskDJLTlqiAssHjCzH")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }

    @Override
    public List<User> findAll() {
        return keycloak.realm("parcial")
                .users()
                .list()
                .stream()
                .map(this::toUser)
                .collect(Collectors.toList());

    }

    @Override
    public User findById(String id) {
        UserRepresentation user = keycloak.realm("parcial").users().get(id).toRepresentation();
        return toUser(user);
    }

    private User toUser(UserRepresentation userRepresentation) {
        List<Bill> billUsers = billRepository.findById(userRepresentation.getId()); //findById(id)
        return new User(userRepresentation.getId(), userRepresentation.getFirstName(), userRepresentation.getEmail(), userRepresentation.getLastName(), billUsers);
    }



}
