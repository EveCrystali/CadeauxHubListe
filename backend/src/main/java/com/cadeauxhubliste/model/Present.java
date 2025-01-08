package com.cadeauxhubliste.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Present {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "list_id", nullable = false) // Clé étrangère vers ListOfPresents
    private ListOfPresents list; // Un cadeau appartient à une seule liste

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "reserved_by_id") // Clé étrangère vers User
    private User reservedBy; 

    public Present() {
    }

    public Present(String name, String description, Status status, ListOfPresents list) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setReservedBy(User reservedBy) {
        this.reservedBy = reservedBy;
    }

    public User getReservedBy() {
        return reservedBy;
    }

}
