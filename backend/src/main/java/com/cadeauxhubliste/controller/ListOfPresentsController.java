package com.cadeauxhubliste.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadeauxhubliste.dto.ListOfPresentsRequest;
import com.cadeauxhubliste.model.ListOfPresents;
import com.cadeauxhubliste.repository.IListOfPresentsRepository;

@RestController
@RequestMapping("/list-of-presents")
public class ListOfPresentsController {

    private final IListOfPresentsRepository listOfPresentsRepository;

    public ListOfPresentsController(IListOfPresentsRepository listOfPresentsRepository) {
        this.listOfPresentsRepository = listOfPresentsRepository;
    }

    @PostMapping
    public ResponseEntity<ListOfPresents> create(@RequestBody ListOfPresentsRequest listOfPresentsRequest) {
        return ResponseEntity.ok(listOfPresentsRepository.save(listOfPresentsRequest.getListOfPresents()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListOfPresents> update(@PathVariable Long id, @RequestBody ListOfPresentsRequest listOfPresentsRequest) {
        ListOfPresents updatedPresent = listOfPresentsRepository.save(listOfPresentsRequest.getListOfPresents());
        return ResponseEntity.ok(updatedPresent); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ListOfPresents> delete(@PathVariable Long id) {
        listOfPresentsRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListOfPresents> get(@PathVariable Long id) {
        return ResponseEntity.ok(listOfPresentsRepository.getReferenceById(id));
    }

    @GetMapping
    public ResponseEntity<List<ListOfPresents>> get() {
        return ResponseEntity.ok(listOfPresentsRepository.findAll());
    }
}