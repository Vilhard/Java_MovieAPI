package com.example.java_movieapi.Repository.Impl;

import com.example.java_movieapi.Repository.Interfaces.IFranchiseRepository;
import com.example.java_movieapi.Repository.Interfaces.IFranchiseRepositoryCustom;

public class FranchiseRepositoryCustomImpl implements IFranchiseRepositoryCustom {
    private final IFranchiseRepository IfranchiseRepository;

    public FranchiseRepositoryCustomImpl(IFranchiseRepository ifranchiseRepository) {
        IfranchiseRepository = ifranchiseRepository;
    }

    @Override
    public void updateMovieInFranchise(int franchiseId) {

    }
}
