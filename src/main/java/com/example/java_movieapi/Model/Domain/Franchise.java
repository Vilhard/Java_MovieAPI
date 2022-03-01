package com.example.java_movieapi.Model.Domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column
    public String name;

    @Column
    public String description;

    @OneToMany(mappedBy = "franchise")
    Set<Movie> movies;
}
