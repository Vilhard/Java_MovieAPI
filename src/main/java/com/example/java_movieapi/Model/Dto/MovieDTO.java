package com.example.java_movieapi.Model.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MovieDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("genre")
    private String genre;

    @JsonProperty("director")
    private String director;

    @JsonProperty("year")
    private int year;

    @JsonProperty("picture")
    private String Picture;

    @JsonProperty("trailer")
    private String trailer;

    @JsonProperty("characters")
    private List<CharacterSlimDTO> characters;

    @JsonProperty("franchise")
    private FranchiseSlimDTO franchise;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public List<CharacterSlimDTO> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterSlimDTO> characters) {
        this.characters = characters;
    }

    public FranchiseSlimDTO getFranchise() {
        return franchise;
    }

    public void setFranchise(FranchiseSlimDTO franchise) {
        this.franchise = franchise;
    }
}
