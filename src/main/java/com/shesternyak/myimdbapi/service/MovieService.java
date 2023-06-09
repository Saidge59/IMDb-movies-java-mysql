package com.shesternyak.myimdbapi.service;

import com.shesternyak.myimdbapi.domain.MovieDB;
import com.shesternyak.myimdbapi.dto.MovieDTO;

import java.util.List;
import java.util.function.Predicate;

public interface MovieService {
    List<MovieDB> getAllMovies();

    MovieDB saveMovies(MovieDB movie);

    MovieDB getById(String id);

    MovieDB updateMovies(MovieDB movie);

    void deleteMovies(MovieDB movie);

    List<MovieDTO> getListMovieDTO(Predicate<MovieDB> predicate);
}
