package com.shesternyak.myimdbapi.service;

import com.shesternyak.myimdbapi.domain.MovieDB;
import com.shesternyak.myimdbapi.dto.MovieDTO;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieDB> getAllMovies();

    MovieDB saveMovies(MovieDTO movieDTO);

    Optional<MovieDB> getById(String id);

    MovieDB updateMovies(MovieDB movie);

    void deleteMovies(MovieDTO movie);
}
