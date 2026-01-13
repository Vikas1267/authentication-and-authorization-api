package com.vikas.authservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    // REQUIRED by JPA
    public Role() {
    }

    // USE THIS CONSTRUCTOR
    public Role(String name) {
        this.name = name;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
