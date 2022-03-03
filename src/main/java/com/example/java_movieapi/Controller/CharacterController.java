package com.example.java_movieapi.Controller;

import com.example.java_movieapi.Model.CommonResponse;
import com.example.java_movieapi.Model.Domain.Character;
import com.example.java_movieapi.Repository.Interfaces.ICharacterRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<CommonResponse<Object>> getCharacterById(@PathVariable int id) {
        Character character = characterRepo.getById(id);
        System.out.println(character);
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(character));
    }
}
