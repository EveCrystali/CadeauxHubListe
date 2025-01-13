package com.cadeauxhubliste.dto;

import com.cadeauxhubliste.model.ListOfPresents;
import com.cadeauxhubliste.model.User;

public class ListOfPresentsRequest {
    ListOfPresents listOfPresents;
    User creator;

    public ListOfPresents getListOfPresents() {
        return listOfPresents;
    }

    public void setListOfPresents(ListOfPresents listOfPresents) {
        this.listOfPresents = listOfPresents;
    }

    public User getCreator() {
        return creator;
    }                            

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
