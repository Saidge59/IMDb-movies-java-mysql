package com.shesternyak.myimdbapi.service;

import com.shesternyak.myimdbapi.domain.MovieFavorites;
import com.shesternyak.myimdbapi.domain.MovieSaved;
import com.shesternyak.myimdbapi.dto.MovieDTO;
import com.shesternyak.myimdbapi.repo.FavoritesMovieRepository;
import com.shesternyak.myimdbapi.repo.SavedMovieRepository;
import com.shesternyak.myimdbapi.system.Convertor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    SavedMovieRepository movieSavedRepository;
    FavoritesMovieRepository movieFavoritesRepository;

    public MovieServiceImpl(SavedMovieRepository movieSavedRepository, FavoritesMovieRepository movieFavoritesRepository) {
        this.movieSavedRepository = movieSavedRepository;
        this.movieFavoritesRepository = movieFavoritesRepository;
    }

    @Override
    public List<MovieSaved> getAllSavedMovies() {
        return movieSavedRepository.findAll();
    }

    @Override
    public List<MovieFavorites> getAllFavoritesMovies() {
        return movieFavoritesRepository.findAll();
    }

    @Override
    public MovieSaved saveSavedMovies(MovieDTO movieDTO) {
        MovieSaved movie = new MovieSaved(movieDTO.getId(), movieDTO.getTitle(), movieDTO.getYear(), movieDTO.getImage(), movieDTO.getCrew(), movieDTO.getImDbRating());
        return movieSavedRepository.save(movie);
    }

    @Override
    public MovieFavorites saveFavoritesMovies(MovieDTO movieDTO) {
        MovieFavorites movie = new MovieFavorites(movieDTO.getId(), movieDTO.getTitle(), movieDTO.getYear(), movieDTO.getImage(), movieDTO.getCrew(), movieDTO.getImDbRating());
        return movieFavoritesRepository.save(movie);
    }

    @Override
    public MovieSaved getSavedMoviesById(int id) {
        return movieSavedRepository.findById(id).get();
    }

    @Override
    public MovieFavorites getFavoritesMoviesById(int id) {
        return movieFavoritesRepository.findById(id).get();
    }

    @Override
    public MovieSaved updateSavedMovies(MovieSaved movie) {
        return movieSavedRepository.save(movie);
    }

    @Override
    public MovieFavorites updateFavoritesMovies(MovieFavorites movie) {
        return movieFavoritesRepository.save(movie);
    }

    @Override
    public void deleteSavedMovies(MovieDTO movie) {
        movieSavedRepository.delete(Convertor.convertMovieDTOToMovieSaved(movie));
    }

    @Override
    public void deleteFavoritesMovies(MovieDTO movie) {
        movieFavoritesRepository.delete(Convertor.convertMovieDTOToMovieFavorites(movie));
    }
}
