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
@RequestMapping("/api")
public class CharacterController {
    private final ICharacterRepository characterRepo;

    public CharacterController(ICharacterRepository characterRepo) {
        this.characterRepo = characterRepo;
    }

    @GetMapping("/character")
    public ResponseEntity<CommonResponse<List<Character>>> getAllCharacters() {
        List<Character> characters = characterRepo.findAll();
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(characters));
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<CommonResponse<Object>> getCharacterById(@PathVariable Integer id) {
        Character character = characterRepo.findById(id).get();
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(character));
    }

    @PostMapping("/character")
    public ResponseEntity<CommonResponse<Character>> addCharacter(@RequestBody Character character) {
        characterRepo.save(character);
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(character));
    }

    @PutMapping("/character/{id}")
    public ResponseEntity<CommonResponse<Object>> updateCharacter(@PathVariable Integer id, @RequestBody Character character) {
        Character foundCharacter = characterRepo.findById(id).get();
        foundCharacter.setFullName(character.getFullName());
        foundCharacter.setAlias(character.getAlias());
        foundCharacter.setGender(character.getGender());
        foundCharacter.setPicture(character.getPicture());
        characterRepo.save(foundCharacter);
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(foundCharacter));
    }

    @DeleteMapping("/character/{id}")
    public ResponseEntity<CommonResponse<String>> deleteCharacter(@PathVariable Integer id) {
        characterRepo.deleteById(id);
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>("Character deleted!"));
    }
}
