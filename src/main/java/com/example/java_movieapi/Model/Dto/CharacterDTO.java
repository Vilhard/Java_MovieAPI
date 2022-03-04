package com.example.java_movieapi.Model.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CharacterDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("picture")
    private String picture;

    @JsonProperty("movies")
    private List<MovieSlimDTO> movies;

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
        this.gender = gender;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<MovieSlimDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieSlimDTO> movies) {
        this.movies = movies;
    }
}
