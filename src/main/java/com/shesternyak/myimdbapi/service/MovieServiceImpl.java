package com.shesternyak.myimdbapi.service;

import com.shesternyak.myimdbapi.domain.MovieDB;
import com.shesternyak.myimdbapi.dto.MovieDTO;
import com.shesternyak.myimdbapi.repo.MovieDBRepository;
import com.shesternyak.myimdbapi.system.Convertor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    MovieDBRepository movieDBRepository;

    public MovieServiceImpl(MovieDBRepository movieDBRepository) {
        this.movieDBRepository = movieDBRepository;
    }

    @Override
    public List<MovieDB> getAllMovies() {
        return movieDBRepository.findAll();
    }

    @Override
    public MovieDB saveMovies(MovieDTO movieDTO) {
        MovieDB movie = new MovieDB(movieDTO.getId(), movieDTO.getTitle(), movieDTO.getYear(), movieDTO.getImage(), movieDTO.getCrew(), movieDTO.getImDbRating(), movieDTO.isSaved(), movieDTO.isFavorites());
        return movieDBRepository.save(movie);
    }

    @Override
    public Optional<MovieDB> getById(String id) {
        return movieDBRepository.findById(id);
    }

    @Override
    public MovieDB updateMovies(MovieDB movie) {
        return movieDBRepository.save(movie);
    }

    @Override
    public void deleteMovies(MovieDTO movie) {
        movieDBRepository.delete(Convertor.convertMovieDTOToMovieDB(movie));
    }
}
