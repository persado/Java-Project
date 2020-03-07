package com.persado.assignment.project.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String summary;

    private long isbn;

    private int copiesPurchased;

    private int available;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
