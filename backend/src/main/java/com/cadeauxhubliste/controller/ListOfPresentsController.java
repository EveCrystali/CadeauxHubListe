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



@RestController
@RequestMapping("/ListOfPresents")
public class ListOfPresentsController {
    

    @PostMapping("/ListOfPresents")
    public ResponseEntity<ListOfPresents> create(@RequestBody ListOfPresentsRequest listOfPresentsRequest) {
        
        // TODO: logic to create a new list of presents

        ListOfPresents listOfPresents = new ListOfPresents();
        
        return ResponseEntity.ok(listOfPresents); 
    }


    @PutMapping("/ListOfPresents/{id}")
    public ResponseEntity<ListOfPresents> edit(@RequestBody ListOfPresents listOfPresents, @PathVariable Long id) {
        
        // TODO: logic to edit a list of presents

        
        return ResponseEntity.ok(listOfPresents); 
    }

    @DeleteMapping("/ListOfPresents/{id}")
    public ResponseEntity<ListOfPresents> delete(@PathVariable Long id) {
        
        // TODO: logic to delete a list of presents

        
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
