package com.example.java_movieapi.Controller;

import com.example.java_movieapi.Model.CommonResponse;
import com.example.java_movieapi.Model.Domain.Movie;
import com.example.java_movieapi.Model.Dto.MovieCreateDTO;
import com.example.java_movieapi.Model.Dto.MovieDTO;
import com.example.java_movieapi.Model.mapper.MapStructMapper;
import com.example.java_movieapi.Repository.Impl.MovieRepositoryImpl;
import com.example.java_movieapi.Repository.Interfaces.IMovieRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name ="Movie")
@RequestMapping("/api")
public class MovieController {
    private final MovieRepositoryImpl movieRepoCustom;
    private final IMovieRepository movieRepo;
    private final MapStructMapper mapStructMapper;

    public MovieController(MovieRepositoryImpl movieRepoCustom, IMovieRepository movieRepo, MapStructMapper mapStructMapper) {
        this.movieRepoCustom = movieRepoCustom;
        this.movieRepo = movieRepo;
        this.mapStructMapper = mapStructMapper;
    }

    @PostMapping("/movie")
    public ResponseEntity<MovieCreateDTO> addMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(mapStructMapper.movieToMovieCreateDTO(movieRepo.save(movie)), HttpStatus.CREATED);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable  Integer id){
        return new ResponseEntity<>(mapStructMapper.movieToMovieDTO(movieRepo.findById(id).get()), HttpStatus.OK);
    }
    @PutMapping("/movie/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable Integer id, @RequestBody MovieDTO movieDTO) {
        Movie movie = movieRepo.findById(id).get();
        movie.setDirector(movieDTO.getDirector());
        movie.setTitle(movieDTO.getTitle());
        movie.setPicture(movieDTO.getTitle());
        movie.setGenre(movieDTO.getGenre());
        movie.setTrailer(movieDTO.getTrailer());
        movie.setPicture(movieDTO.getPicture());
        movie.setYear(movieDTO.getYear());
        return new ResponseEntity<>(mapStructMapper.movieToMovieDTO(movieRepo.save(movie)), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/movie/{id}")
    public ResponseEntity<CommonResponse<String>> deleteMovie(@PathVariable Integer id) {
        movieRepo.deleteById(id);
        return ResponseEntity.ok().body(new CommonResponse<>("Movie deleted!"));
    }
}
