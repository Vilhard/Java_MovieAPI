package com.example.java_movieapi.Controller;

import com.example.java_movieapi.Model.CommonResponse;
import com.example.java_movieapi.Model.Domain.Movie;
import com.example.java_movieapi.Repository.Impl.MovieRepositoryImpl;
import com.example.java_movieapi.Repository.Interfaces.IMovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    private final MovieRepositoryImpl movieRepoCustom;
    private final IMovieRepository movieRepo;

    public MovieController(MovieRepositoryImpl movieRepoCustom, IMovieRepository movieRepo) {
        this.movieRepoCustom = movieRepoCustom;
        this.movieRepo = movieRepo;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<Object>> getMovieById(@PathVariable  Integer id){
        Movie movie = movieRepo.getById(id);
        System.out.println(movie);
        return ResponseEntity.ok().body(new CommonResponse<>(movie));
    }
}
