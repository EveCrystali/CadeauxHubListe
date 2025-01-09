package com.cadeauxhubliste.repository;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cadeauxhubliste.model.User;

@Repository
public class UserRepository {

    private final IUserRepository userRepository;

    // Constructor to inject the IUserRepository dependency
    public UserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {
        Objects.requireNonNull(username, "Username must not be null");
        return userRepository.findAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    

}
