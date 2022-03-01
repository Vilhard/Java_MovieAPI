package com.example.java_movieapi.Model.Domain;

import com.example.java_movieapi.Model.Domain.Character;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Character> characters;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;
}
