package com.cadeauxhubliste.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ListOfPresents {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User owner;

    @ManyToMany
    @JoinTable(name="shared_list_users", joinColumns=@JoinColumn(name="list_id"), inverseJoinColumns=@JoinColumn(name="user_id"))
    private Set<User> sharedWith= new HashSet<>();

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<Present> presents;

    public ListOfPresents() {
    }

    public ListOfPresents(User owner, String title, List<Present> presents) {
        this.title = title;
        this.owner = owner;
        this.presents = presents;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Present> getPresents() {
        return presents;
    }

    public void setPresents(List<Present> presents) {
        this.presents = presents;
    }

}
