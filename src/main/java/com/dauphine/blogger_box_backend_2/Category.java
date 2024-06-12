package com.dauphine.blogger_box_backend_2;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;





public class Category {

    private UUID id;

    private String name;


    public Category(String name) {
        this.name = name;
    }

    public Category() {}


    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}

