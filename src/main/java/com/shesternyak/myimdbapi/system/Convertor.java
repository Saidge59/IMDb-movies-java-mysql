package com.shesternyak.myimdbapi.system;

import com.shesternyak.myimdbapi.domain.Movie;
import com.shesternyak.myimdbapi.domain.MovieDB;
import com.shesternyak.myimdbapi.dto.MovieDTO;

import java.util.ArrayList;
import java.util.List;

public class Convertor {

    public static List<MovieDTO> convertMovieToMovieDTO(List<Movie> movies) {
        List<MovieDTO> movieDTOs = new ArrayList<>();
        for (Movie m : movies) {
            MovieDTO movieDTO = new MovieDTO(m.getId(), m.getTitle(), m.getYear(), m.getImage(), m.getCrew(), m.getImDbRating());
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    public static MovieDB convertMovieDTOToMovieDB(MovieDTO movie) {
        return new MovieDB(movie.getId(), movie.getTitle(), movie.getYear(), movie.getImage(), movie.getCrew(), movie.getImDbRating(), movie.isSaved(), movie.isFavorites());
    }

    public static List<MovieDTO> convertMovieDBToMovieDTO(List<MovieDB> movies) {
        List<MovieDTO> movieDTOs = new ArrayList<>();
        for (MovieDB m : movies) {
            MovieDTO movieDTO = new MovieDTO(m.getId(), m.getTitle(), m.getYear(), m.getImage(), m.getCrew(), m.getImDbRating(), m.isSaved(), m.isFavorites());
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }
}
