package com.example.java_movieapi.Model.mapper;

import com.example.java_movieapi.Model.Domain.Character;
import com.example.java_movieapi.Model.Domain.Franchise;
import com.example.java_movieapi.Model.Domain.Movie;
import com.example.java_movieapi.Model.Dto.*;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    CharacterSlimDTO characterToCharacterSlimDTO(Character character);
    FranchiseSlimDTO franchiseToFranchiseSlimDTO(Franchise franchise);
    MovieSlimDTO movieToMovieSlimDTO(Movie movie);
    MovieDTO movieToMovieDTO(Movie movie);
    CharacterDTO characterToCharacterDTO(Character character);
    FranchiseDTO franchiseToFranchiseDTO(Franchise franchise);
    MovieCreateDTO movieToMovieCreateDTO(Movie movie);
    CharacterCreateDTO characterToCharacterCreateDTO(Character character);
    FranchiseCreateDTO franchiseToFranchiseCreateDTO(Franchise franchise);
}
