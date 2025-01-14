package com.cadeauxhubliste.controller;

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
import com.cadeauxhubliste.service.ListOfPresentsService;

@RestController
@RequestMapping("/ListOfPresents")
public class ListOfPresentsController {

    private final IListOfPresentsRepository listOfPresentsRepository;
    private final ListOfPresentsService listOfPresentsService;

    public ListOfPresentsController(IListOfPresentsRepository listOfPresentsRepository, ListOfPresentsService listOfPresentsService) {
        this.listOfPresentsRepository = listOfPresentsRepository;
        this.listOfPresentsService = listOfPresentsService;
    }

    @PostMapping("/ListOfPresents")
    public ResponseEntity<ListOfPresents> create(@RequestBody ListOfPresentsRequest listOfPresentsRequest) {

        ListOfPresents listOfPresents = listOfPresentsRepository.save(listOfPresentsRequest.getListOfPresents());

        return ResponseEntity.ok(listOfPresents);
    }

    @PutMapping("/ListOfPresents/{id}")
    public ResponseEntity<ListOfPresents> update(@PathVariable Long id, @RequestBody ListOfPresentsRequest listOfPresentsRequest) {
        ListOfPresents updatedPresent = listOfPresentsRepository.save(listOfPresentsRequest.getListOfPresents());
        return ResponseEntity.ok(updatedPresent);
    }

    @DeleteMapping("/ListOfPresents/{id}")
    public ResponseEntity<ListOfPresents> delete(@PathVariable Long id) {

        listOfPresentsRepository.deleteById(id);

        // ? Faut-il supprimer les presents de la liste (ou la cascade se fait correctement)?

        return ResponseEntity.ok(null);
    }

    @GetMapping("/ListOfPresents/{id}")
    public ResponseEntity<ListOfPresents> get(@PathVariable Long id) {

        //TODO: logic to get a list of presents by id
        return ResponseEntity.ok(null);
    }

    @GetMapping("/ListOfPresents")
    public ResponseEntity<ListOfPresents> get() {

        //TODO: logic to get all list of presents
        return ResponseEntity.ok(null);
    }
}
