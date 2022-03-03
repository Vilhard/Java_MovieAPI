package com.example.java_movieapi.Model.Domain;

import com.example.java_movieapi.Model.Domain.Character;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Movie")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 150, nullable = false)
    private String title;

    @Column
    @Type(type="integer")
    private int year;

    @Column(length = 100)
    private String genre;

    @Column(length = 100)
    private String director;

    @Column(length = 200)
    private String picture;

    @Column(length = 200)
    private String trailer;

    @ManyToMany
    @JoinTable(
            name="movie_character",
            joinColumns={@JoinColumn(name="movie_id")},
            inverseJoinColumns = {@JoinColumn(name= "character_id")}
    )
    private Set<Character> characters;

    @ManyToOne
    @JoinColumn(name = "franchise_id", insertable=false, updatable=false)
    private Franchise franchise;

    public Movie() {
    }

    public Movie(Integer id, String title, int year, String genre, Franchise franchise, String director, String picture, String trailer) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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
