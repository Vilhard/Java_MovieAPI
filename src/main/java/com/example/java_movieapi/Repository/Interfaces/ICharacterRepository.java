package com.example.java_movieapi.Repository.Interfaces;

import com.example.java_movieapi.Model.Domain.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterRepository extends JpaRepository<Character, Integer> {
}
