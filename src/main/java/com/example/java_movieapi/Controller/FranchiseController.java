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

    @PostMapping("/franchise")
    public ResponseEntity<FranchiseCreateDTO> addfranchise(@RequestBody Franchise franchise) {
       return new ResponseEntity<>(mapStructMapper.franchiseToFranchiseCreateDTO(franchiseRepo.save(franchise)), HttpStatus.CREATED);
    }

    @GetMapping("/franchise/{id}")
    public ResponseEntity<FranchiseDTO> getFranchiseById(@PathVariable Integer id) {
        return new ResponseEntity<>(mapStructMapper.franchiseToFranchiseDTO(franchiseRepo.findById(id).get()), HttpStatus.OK);
    }

    @PutMapping("/franchise/{id}")
    public ResponseEntity<CommonResponse<Franchise>> updateFranchise(@PathVariable Integer id, @RequestBody Franchise franchise) {
        Franchise foundFranchise = franchiseRepo.findById(id).get();
        foundFranchise.setName(franchise.getName());
        foundFranchise.setDescription(franchise.getDescription());
        foundFranchise.setMovies(franchise.getMovies());
        franchiseRepo.save(foundFranchise);
        return ResponseEntity.ok().body(new CommonResponse<>(foundFranchise));
    }

     @DeleteMapping("/franchise/{id}")
    public ResponseEntity<CommonResponse<String>> deleteFranchise(@PathVariable Integer id) {
         franchiseRepo.deleteById(id);
         return ResponseEntity.ok().body(new CommonResponse<>("Franchise deleted!"));
    }

    @GetMapping("/franchise/{id}/movies")
    public ResponseEntity<CommonResponse<List<Movie>>> getAllMoviesInFranchise(@PathVariable Integer id) {
        Franchise franchise = franchiseRepo.findById(id).get();
        List<Movie> moviesInFranchise = franchise.getMovies();

        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(moviesInFranchise));
    }

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
