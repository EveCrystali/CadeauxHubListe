package com.cadeauxhubliste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadeauxhubliste.model.ListOfPresents;


@Repository
public interface IListOfPresentsRepository extends JpaRepository<ListOfPresents, Long> {

}
