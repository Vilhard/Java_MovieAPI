package com.example.java_movieapi.Repository.Interfaces;

import com.example.java_movieapi.Model.Domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends IMovieRepositoryCustom, JpaRepository<Movie, Integer> {

}
