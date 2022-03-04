package com.example.java_movieapi.Controller;

import com.example.java_movieapi.Model.CommonResponse;
import com.example.java_movieapi.Model.Domain.Character;
import com.example.java_movieapi.Model.Domain.Franchise;
import com.example.java_movieapi.Model.Domain.Movie;
import com.example.java_movieapi.Model.Dto.FranchiseCreateDTO;
import com.example.java_movieapi.Model.Dto.FranchiseDTO;
import com.example.java_movieapi.Model.mapper.MapStructMapper;
import com.example.java_movieapi.Repository.Interfaces.IFranchiseRepository;
import com.example.java_movieapi.Repository.Interfaces.IMovieRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Franchise")
@RequestMapping("/api")
public class FranchiseController {
    private final IFranchiseRepository franchiseRepo;
    private final MapStructMapper mapStructMapper;
    private final IMovieRepository movieRepo;

    public FranchiseController(IFranchiseRepository franchiseRepo, MapStructMapper mapStructMapper, IMovieRepository movieRepo) {
        this.franchiseRepo = franchiseRepo;
        this.mapStructMapper = mapStructMapper;
        this.movieRepo = movieRepo;
    }

    @Operation(summary = "Adds a new franchise")
    @PostMapping("/franchise")
    public ResponseEntity<FranchiseCreateDTO> addfranchise(@RequestBody Franchise franchise) {
       return new ResponseEntity<>(mapStructMapper.franchiseToFranchiseCreateDTO(franchiseRepo.save(franchise)), HttpStatus.CREATED);
    }

    @Operation(summary = "Gets all franchises")
    @GetMapping("/franchise")
    public ResponseEntity<CommonResponse<List<Franchise>>> getAllFranchises() {
        List<Franchise> franchises = franchiseRepo.findAll();
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(franchises));
    }

    @Operation(summary = "Gets a franchise by id")
    @GetMapping("/franchise/{id}")
    public ResponseEntity<FranchiseDTO> getFranchiseById(@PathVariable Integer id) {
        return new ResponseEntity<>(mapStructMapper.franchiseToFranchiseDTO(franchiseRepo.findById(id).get()), HttpStatus.OK);
    }

    @Operation(summary = "Updates a franchise by id")
    @PutMapping("/franchise/{id}")
    public ResponseEntity<FranchiseDTO> updateFranchise(@PathVariable Integer id, @RequestBody FranchiseDTO franchiseDTO) {
        Franchise franchise = franchiseRepo.findById(id).get();
        franchise.setName(franchiseDTO.getName());
        franchise.setDescription(franchiseDTO.getDescription());
        franchiseRepo.save(franchise);
        return new ResponseEntity<>(mapStructMapper.franchiseToFranchiseDTO(franchiseRepo.save(franchise)), HttpStatus.ACCEPTED);

    }

    @Operation(summary = "Deletes a franchise by id")
    @DeleteMapping("/franchise/{id}")
    public ResponseEntity<CommonResponse<String>> deleteFranchise(@PathVariable Integer id) {
         franchiseRepo.deleteById(id);
         return ResponseEntity.ok().body(new CommonResponse<>("Franchise deleted!"));
    }

    @Operation(summary = "Gets movies in franchise by franchises id")
    @GetMapping("/franchise/{id}/movies")
    public ResponseEntity<CommonResponse<List<Movie>>> getAllMoviesInFranchise(@PathVariable Integer id) {
        Franchise franchise = franchiseRepo.findById(id).get();
        List<Movie> moviesInFranchise = franchise.getMovies();

        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(moviesInFranchise));
    }

    @Operation(summary = "Gets characters in franchise by franchises id")
    @GetMapping("/franchise/{id}/characters")
    public ResponseEntity<CommonResponse<List<Character>>> getAllCharactersInFranchise(@PathVariable Integer id) {
        Optional<Franchise> franchise = franchiseRepo.findById(id);
        List<Character> charactersInFranchise = new ArrayList<>();
        if(franchise.isPresent()) {
            for(Movie movie: franchise.get().getMovies()) {
                charactersInFranchise.addAll(movie.getCharacters());
            }
        }

        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(charactersInFranchise));
    }

    @Operation(summary = "Updates movies in franchise by franchises id")
    @PutMapping("/franchise/{id}/movies")
    public ResponseEntity<CommonResponse<Franchise>> updateMoviesInFranchise(@PathVariable Integer id, @RequestBody Integer[] movieId) {
        Franchise franchise = franchiseRepo.findById(id).get();
        List<Movie> allMovies = movieRepo.findAll();
        List<Movie> updatedMovies = new ArrayList<>();
        for(Movie movie: allMovies) {
            if(List.of(movieId).contains(movie.getId())) {
                updatedMovies.add(movie);
            }
        }
        franchise.setMovies(updatedMovies);
        franchiseRepo.save(franchise);

        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(franchise));
    }

}
