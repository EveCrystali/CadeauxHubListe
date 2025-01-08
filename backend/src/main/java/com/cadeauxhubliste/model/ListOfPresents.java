package com.cadeauxhubliste.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ListOfPresents {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<Present> presents;

    public ListOfPresents(User user, String title, List<Present> presents) {
        this.title = title;
        this.user = user;
        this.presents = presents;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<Present> getPresents() {
        return presents;
    }

    public void setPresents(List<Present> presents) {
        this.presents = presents;
    }

}
