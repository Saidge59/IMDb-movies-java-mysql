package com.shesternyak.myimdbapi.service;

import com.shesternyak.myimdbapi.domain.MovieDB;
import com.shesternyak.myimdbapi.dto.MovieDTO;
import com.shesternyak.myimdbapi.repo.MovieDBRepository;
import com.shesternyak.myimdbapi.system.Convertor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class MovieServiceImpl implements MovieService {

    MovieDBRepository movieDBRepository;

    public MovieServiceImpl(MovieDBRepository movieDBRepository) {
        this.movieDBRepository = movieDBRepository;
    }

    @Override
    public List<MovieDB> getAllMovies() {
        return movieDBRepository.findAll();
    }

    @Override
    public MovieDB saveMovies(MovieDB movie) {
        return movieDBRepository.save(movie);
    }

    @Override
    public MovieDB getById(String id) {
        Optional<MovieDB> byId = movieDBRepository.findById(id);
        return byId.orElseGet(MovieDB::new);
    }

    @Override
    public MovieDB updateMovies(MovieDB movie) {
        return movieDBRepository.save(movie);
    }

    @Override
    public void deleteMovies(MovieDB movie) {
        movieDBRepository.delete(movie);
    }

    @Override
    public List<MovieDTO> getListMovieDTO(Predicate<MovieDB> predicate) {
        List<MovieDB> movies = movieDBRepository.findAll();
        List<MovieDTO> moviesDTO = Collections.emptyList();

        if (movies != null) {
            movies = movies.stream().filter(predicate).toList();
            moviesDTO = Convertor.convertMovieDBToMovieDTO(movies);
        }
        return moviesDTO;
    }
}
