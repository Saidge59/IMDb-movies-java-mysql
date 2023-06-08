package com.shesternyak.myimdbapi.service;

import com.shesternyak.myimdbapi.domain.Movie;
import com.shesternyak.myimdbapi.domain.MovieFavorites;
import com.shesternyak.myimdbapi.domain.MovieSaved;
import com.shesternyak.myimdbapi.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    List<MovieSaved> getAllSavedMovies();
    List<MovieFavorites> getAllFavoritesMovies();

    MovieSaved saveSavedMovies(MovieDTO movieDTO);
    MovieFavorites saveFavoritesMovies(MovieDTO movieDTO);

    MovieSaved getSavedMoviesById(int id);
    MovieFavorites getFavoritesMoviesById(int id);

    MovieSaved updateSavedMovies(MovieSaved movie);
    MovieFavorites updateFavoritesMovies(MovieFavorites movie);

    void deleteSavedMovies(int id);
    void deleteFavoritesMovies(int id);
}
