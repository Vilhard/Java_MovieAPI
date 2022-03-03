package com.example.java_movieapi.Controller;

import com.example.java_movieapi.Model.CommonResponse;
import com.example.java_movieapi.Model.Domain.Character;
import com.example.java_movieapi.Repository.Interfaces.ICharacterRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Character")
@RequestMapping("/api/character")
public class CharacterController {
    private final ICharacterRepository characterRepo;

    public CharacterController(ICharacterRepository characterRepo) {
        this.characterRepo = characterRepo;
    }

    @GetMapping("/all")
    public ResponseEntity<CommonResponse<List<Character>>> getAllCharacters() {
        List<Character> characters = characterRepo.findAll();
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(characters));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<Object>> getCharacterById(@PathVariable Integer id) {
        Character character = characterRepo.findById(id).get();
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(character));
    }

    @PostMapping("/add")
    public ResponseEntity<CommonResponse<Object>> createCharacter(@RequestBody Character character) {
        Character newCharacter = characterRepo.save(character);
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(newCharacter));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CommonResponse<Object>> updateCharacter(@PathVariable Integer id, @RequestBody Character character) {
        Character updatedCharacter = characterRepo.save(character);
        if(!id.equals(character.getId())) {
            return ResponseEntity
                    .badRequest()
                    .body(new CommonResponse<>("Id does not exist"));
        }
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(updatedCharacter));
    }
}
