package com.example.java_movieapi.Model.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieSlimDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

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
}
