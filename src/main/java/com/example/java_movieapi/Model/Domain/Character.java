package com.example.java_movieapi.Model.Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

     @Column(name = "full_name")
    public String fullName;

     @Column
    public String alias;

     @Column
    public String picture;

     @ManyToMany(mappedBy = "movie")
     public Set<Movie> movies;

    public Character() {

    }

    public Character(Integer id, String fullName, String alias, String picture) {
        this.id = id;
        this.fullName = fullName;
        this.alias = alias;
        this.picture = picture;
        this.movies = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
