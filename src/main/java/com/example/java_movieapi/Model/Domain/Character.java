package com.example.java_movieapi.Model.Domain;

import javax.persistence.*;
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

     @ManyToMany(mappedBy = "characters")
    public Set<Movie> movies;
}
