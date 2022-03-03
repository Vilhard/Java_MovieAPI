package com.example.java_movieapi.Model.Domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

     @Column(name = "full_name", length = 100 ,nullable = false)
    public String fullName;

     @Column(length = 100)
    public String alias;

    @Column(length = 20)
    public String gender;

     @Column(length = 200)
    public String picture;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

     public Set<Movie> movies;

    public Character() {

    }

    public Character(Integer id, String fullName, String alias, String gender,String picture) {
        this.id = id;
        this.fullName = fullName;
        this.alias = alias;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.alias = gender;
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
