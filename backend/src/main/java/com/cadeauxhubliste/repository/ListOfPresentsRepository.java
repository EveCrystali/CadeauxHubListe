package com.cadeauxhubliste.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ListOfPresentsRepository {

    private final IListOfPresentsRepository listOfPresentsRepository;

    public ListOfPresentsRepository(IListOfPresentsRepository listOfPresentsRepository) {
        this.listOfPresentsRepository = listOfPresentsRepository;
    }
}