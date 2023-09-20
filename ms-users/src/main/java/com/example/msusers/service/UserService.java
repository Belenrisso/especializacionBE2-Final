package com.example.msusers.service;

import com.example.msusers.domain.User;
import com.example.msusers.repository.IUserRepository;
import com.example.msusers.repository.KeyCloakUserRepository;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private IUserRepository userRepository;
private final KeyCloakUserRepository keyCloakUserRepository;

    public UserService(IUserRepository userRepository, KeyCloakUserRepository keyCloakUserRepository) {
        this.userRepository = userRepository;
        this.keyCloakUserRepository = keyCloakUserRepository;
    }

    public List<User> findAll() {
        return keyCloakUserRepository.findAll();
    }
    public User findById(String id){
        return userRepository.findById(id);
    }

}




