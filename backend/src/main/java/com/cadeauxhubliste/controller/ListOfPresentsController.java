package com.cadeauxhubliste.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadeauxhubliste.dto.ListOfPresentsRequest;
import com.cadeauxhubliste.model.ListOfPresents;

@RestController
@RequestMapping("/ListOfPresents")
public class ListOfPresentsController {
    



    @PostMapping("/ListOfPresents")
    public ResponseEntity<ListOfPresents> createListOfPresents(@RequestBody ListOfPresentsRequest listOfPresentsRequest) {
        
        // TODO: logic to create a new list of presents

        ListOfPresents listOfPresents = new ListOfPresents();
        
        return ResponseEntity.ok(listOfPresents); 
    }
}
