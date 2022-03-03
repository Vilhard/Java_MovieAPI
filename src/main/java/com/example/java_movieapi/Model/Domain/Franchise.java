package com.example.java_movieapi.Model.Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 100, nullable = false)
    public String name;

    @Column
    public String description;

    @OneToMany(mappedBy = "franchise")
    public List<Movie> movies;

    public Franchise() {

    }

    public Franchise(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.movies = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
