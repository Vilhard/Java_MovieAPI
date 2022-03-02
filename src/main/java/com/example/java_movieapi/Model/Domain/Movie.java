package com.example.java_movieapi.Model.Domain;

import com.example.java_movieapi.Model.Domain.Character;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column
    private String title;

    @Column
    private String year;

    @Column
    private String genre;

    @Column
    private String director;

    @Column
    private String picture;

    @Column
    private String trailer;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Character> characters;

    @ManyToOne
    @JoinColumn(name = "id", insertable=false, updatable=false)
    private Franchise franchise;

    public Movie() {
    }

    public Movie(Integer id, String title, String year, String genre, Franchise franchise, String director, String picture, String trailer) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.picture = picture;
        this.trailer = trailer;
        this.franchise = franchise;
        this.characters = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }
}
