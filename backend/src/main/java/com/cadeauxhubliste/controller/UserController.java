package com.cadeauxhubliste.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadeauxhubliste.model.ListOfPresents;
import com.cadeauxhubliste.model.User;
import com.cadeauxhubliste.repository.IListOfPresentsRepository;
import com.cadeauxhubliste.repository.IUserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserRepository userRepository;
    private final IListOfPresentsRepository listOfPresentsRepository;

    public UserController(IUserRepository userRepository, IListOfPresentsRepository listOfPresentsRepository) {
        this.userRepository = userRepository;
        this.listOfPresentsRepository = listOfPresentsRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> get() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userRepository.findById(id).orElse(null));
    }

    @GetMapping("/{userId}/list-of-presents/owned")
    public ResponseEntity<List<ListOfPresents>> getAllListOfPresentsOfAUser(@PathVariable Long userId) {
        List<ListOfPresents> listsOfPresents = listOfPresentsRepository.findAll().stream()
                .filter(l -> l.getOwner().getId().equals(userId)).toList();
        return ResponseEntity.ok(listsOfPresents);
    }

    @GetMapping("/{userId}/list-of-presents/participating")
    public ResponseEntity<List<ListOfPresents>> getAllListOfPresentsWhereAUserIsParticipatingById(@PathVariable Long userId) {
        List<ListOfPresents> listsOfPresents = listOfPresentsRepository.findAll().stream()
                .filter(l -> l.getParticipants().stream().anyMatch(p -> p.getId().equals(userId))).toList();
        return ResponseEntity.ok(listsOfPresents);
    }
}
