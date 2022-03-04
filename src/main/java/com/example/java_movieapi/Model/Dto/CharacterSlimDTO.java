package com.example.java_movieapi.Model.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterSlimDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("full_name")
    private String fullName;

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
}
