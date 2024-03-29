package com.example.restdemo.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
