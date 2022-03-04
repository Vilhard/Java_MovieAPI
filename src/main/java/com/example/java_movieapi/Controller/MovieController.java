package com.example.java_movieapi.Controller;

import com.example.java_movieapi.Model.CommonResponse;
import com.example.java_movieapi.Model.Domain.Character;
import com.example.java_movieapi.Model.Domain.Movie;
import com.example.java_movieapi.Model.Dto.MovieCreateDTO;
import com.example.java_movieapi.Model.Dto.MovieDTO;
import com.example.java_movieapi.Model.mapper.MapStructMapper;
import com.example.java_movieapi.Repository.Interfaces.ICharacterRepository;
import com.example.java_movieapi.Repository.Interfaces.IMovieRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@Tag(name ="Movie")
@RequestMapping("/api")
public class MovieController {
    private final IMovieRepository movieRepo;
    private final MapStructMapper mapStructMapper;
    private final ICharacterRepository characterRepo;

    public MovieController(IMovieRepository movieRepo, MapStructMapper mapStructMapper, ICharacterRepository characterRepo) {
        this.movieRepo = movieRepo;
        this.mapStructMapper = mapStructMapper;
        this.characterRepo = characterRepo;
    }

    @Operation(summary = "Adds a new movie")
    @PostMapping("/movie")
    public ResponseEntity<MovieCreateDTO> addMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(mapStructMapper.movieToMovieCreateDTO(movieRepo.save(movie)), HttpStatus.CREATED);
    }

    @Operation(summary = "Gets all movies")
    @GetMapping("/movie")
    public ResponseEntity<CommonResponse<List<Movie>>> getAllCharacters() {
        List<Movie> movies = movieRepo.findAll();
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(movies));
    }

    @Operation(summary = "Gets a movie by id")
    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable  Integer id){
        return new ResponseEntity<>(mapStructMapper.movieToMovieDTO(movieRepo.findById(id).get()), HttpStatus.OK);
    }

    @Operation(summary = "Updates a movie by id")
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

    @Operation(summary = "Deletes a movie by id")
    @DeleteMapping("/movie/{id}")
    public ResponseEntity<CommonResponse<String>> deleteMovie(@PathVariable Integer id) {
        movieRepo.deleteById(id);
        return ResponseEntity.ok().body(new CommonResponse<>("Movie deleted!"));
    }

    @Operation(summary = "Gets characters in movie by movies id")
    @GetMapping("/movie/{id}/characters")
    public ResponseEntity<CommonResponse<Set<Character>>> getAllCharactersInMovie(@PathVariable Integer id) {
        Movie movie = movieRepo.findById(id).get();
        Set<Character> charactersInMovie = movie.getCharacters();
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(charactersInMovie));
    }

    @Operation(summary = "Updates characters in movie by movies id")
    @PutMapping("/movie/{id}/characters")
    public ResponseEntity<CommonResponse<Movie>> updateCharactersInMovie(@PathVariable Integer id, @RequestBody Integer[] characterId) {
        Movie movie = movieRepo.findById(id).get();
        List<Character> allCharacters = characterRepo.findAll();
        List<Character> updatedCharacters = new ArrayList<>();
        for(Character character: allCharacters) {
            if(List.of(characterId).contains(character.getId())) {
                updatedCharacters.add(character);
            }
        }
        Set<Character> updatedCharacter = new HashSet<>(updatedCharacters);
        movie.setCharacters(updatedCharacter);
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(movie));
    }
}
