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
    public ResponseEntity<CommonResponse<Movie>> postMovie(@RequestBody Movie movie) {
        movieRepo.save(movie);
        return ResponseEntity.ok(new CommonResponse<>(movie));
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<CommonResponse<Object>> getMovieById(@PathVariable  Integer id){
        Movie movie = movieRepo.findById(id).get();
        System.out.println(movie);
        return ResponseEntity.ok().body(new CommonResponse<>(movie));
    }


}
