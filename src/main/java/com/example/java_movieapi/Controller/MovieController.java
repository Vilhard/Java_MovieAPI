package com.example.java_movieapi.Controller;

import com.example.java_movieapi.Model.CommonResponse;
import com.example.java_movieapi.Model.Domain.Movie;
import com.example.java_movieapi.Repository.Impl.MovieRepositoryImpl;
import com.example.java_movieapi.Repository.Interfaces.IMovieRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name ="Movie")
@RequestMapping("/api")
public class MovieController {
    private final MovieRepositoryImpl movieRepoCustom;
    private final IMovieRepository movieRepo;

    public MovieController(MovieRepositoryImpl movieRepoCustom, IMovieRepository movieRepo) {
        this.movieRepoCustom = movieRepoCustom;
        this.movieRepo = movieRepo;
    }

    @PostMapping("/movie")
    public ResponseEntity<CommonResponse<Movie>> addMovie(@RequestBody Movie movie) {
        movieRepo.save(movie);
        return ResponseEntity.ok(new CommonResponse<>(movie));
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<CommonResponse<Movie>> getMovieById(@PathVariable  Integer id){
        Movie movie = movieRepo.findById(id).get();
        System.out.println(movie);
        return ResponseEntity.ok().body(new CommonResponse<>(movie));
    }
    @PutMapping("/movie/{id}")
    public ResponseEntity<CommonResponse<Movie>> updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        Movie foundMovie = movieRepo.findById(id).get();
        foundMovie.setDirector(movie.getDirector());
        foundMovie.setTitle(movie.getTitle());
        foundMovie.setPicture(movie.getTitle());
        foundMovie.setGenre(movie.getGenre());
        foundMovie.setTrailer(movie.getTrailer());
        foundMovie.setPicture(movie.getPicture());
        foundMovie.setYear(movie.getYear());
        foundMovie.setFranchise(movie.getFranchise());
        movieRepo.save(foundMovie);
        return ResponseEntity.ok().body(new CommonResponse<>(foundMovie));
    }
}
