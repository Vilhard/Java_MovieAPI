package com.example.java_movieapi.Controller;

import com.example.java_movieapi.Model.CommonResponse;
import com.example.java_movieapi.Model.Domain.Franchise;
import com.example.java_movieapi.Model.Dto.FranchiseDTO;
import com.example.java_movieapi.Model.mapper.MapStructMapper;
import com.example.java_movieapi.Repository.Interfaces.IFranchiseRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Franchise")
@RequestMapping("/api")
public class FranchiseController {
    private final IFranchiseRepository franchiseRepo;
    private final MapStructMapper mapStructMapper;

    public FranchiseController(IFranchiseRepository franchiseRepo, MapStructMapper mapStructMapper) {
        this.franchiseRepo = franchiseRepo;
        this.mapStructMapper = mapStructMapper;
    }

    @PostMapping("/franchise")
    public ResponseEntity<CommonResponse<Franchise>> addfranchise(@RequestBody Franchise franchise) {
        franchiseRepo.save(franchise);
        return ResponseEntity.ok().body(new CommonResponse<>(franchise));
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
}
