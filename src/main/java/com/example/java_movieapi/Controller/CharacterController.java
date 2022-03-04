package com.example.java_movieapi.Controller;

import com.example.java_movieapi.Model.CommonResponse;
import com.example.java_movieapi.Model.Domain.Character;
import com.example.java_movieapi.Model.Dto.CharacterCreateDTO;
import com.example.java_movieapi.Model.Dto.CharacterDTO;
import com.example.java_movieapi.Model.mapper.MapStructMapper;
import com.example.java_movieapi.Repository.Interfaces.ICharacterRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Character")
@RequestMapping("/api")
public class CharacterController {
    private final ICharacterRepository characterRepo;
    private final MapStructMapper mapStructMapper;

    public CharacterController(ICharacterRepository characterRepo, MapStructMapper mapStructMapper) {
        this.characterRepo = characterRepo;
        this.mapStructMapper = mapStructMapper;
    }

    @GetMapping("/character")
    public ResponseEntity<CommonResponse<List<Character>>> getAllCharacters() {
        List<Character> characters = characterRepo.findAll();
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(characters));
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable Integer id) {
        return new ResponseEntity<>(mapStructMapper.characterToCharacterDTO(characterRepo.findById(id).get()), HttpStatus.OK);
    }

    @PostMapping("/character")
    public ResponseEntity<CharacterCreateDTO> addCharacter(@RequestBody Character character) {
        return new ResponseEntity<>(mapStructMapper.characterToCharacterCreateDTO(characterRepo.save(character)), HttpStatus.CREATED);
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
