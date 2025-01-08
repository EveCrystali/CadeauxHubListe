package com.cadeauxhubliste.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ListOfPresents> listOfListOfPresents;

    @OneToMany(mappedBy = "reservedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Present> reservedPresents;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ListOfPresents> getListOfListOfPresents() {
        return listOfListOfPresents;
    }

    public void setListOfListOfPresents(List<ListOfPresents> listOfListOfPresents) {
        this.listOfListOfPresents = listOfListOfPresents;
    }

    public List<Present> getReservedPresents() {
        return reservedPresents;
    }

    public void setReservedPresents(List<Present> reservedPresents) {
        this.reservedPresents = reservedPresents;
    }
}
