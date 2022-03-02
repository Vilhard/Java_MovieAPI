package com.example.java_movieapi.Repository.Impl;

import com.example.java_movieapi.Repository.Interfaces.IMovieRepository;
import com.example.java_movieapi.Repository.Interfaces.IMovieRepositoryCustom;

public class MovieRepositoryCustomImpl implements IMovieRepositoryCustom {
    private final IMovieRepository ImovieRepository;

    public MovieRepositoryCustomImpl(IMovieRepository imovieRepository) {
        ImovieRepository = imovieRepository;
    }

    @Override
    public void updateCharacterInMovie(int MovieId) {

    }
}
