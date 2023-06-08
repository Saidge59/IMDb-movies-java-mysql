package com.shesternyak.myimdbapi.system;

import com.shesternyak.myimdbapi.domain.Movie;
import com.shesternyak.myimdbapi.domain.MovieFavorites;
import com.shesternyak.myimdbapi.domain.MovieSaved;
import com.shesternyak.myimdbapi.dto.MovieDTO;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
//    public static <T extends Movie> List<MovieDTO> convertMovieTToMovieDTO(List<T> movies) {
//        List<MovieDTO> movieDTOs = new ArrayList<>();
//        for (T m : movies) {
//            MovieDTO movieDTO = new MovieDTO(m.getId(), m.getTitle(), m.getYear(), m.getImage(), m.getCrew(), m.getImDbRating());
//            movieDTOs.add(movieDTO);
//        }
//        return movieDTOs;
//    }

    public static List<MovieDTO> convertMovieToMovieDTO(List<Movie> movies) {
        List<MovieDTO> movieDTOs = new ArrayList<>();
        for (Movie m : movies) {
            MovieDTO movieDTO = new MovieDTO(m.getId(), m.getTitle(), m.getYear(), m.getImage(), m.getCrew(), m.getImDbRating());
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    public static List<MovieDTO> convertMovieSavedToMovieDTO(List<MovieSaved> movies) {
        List<MovieDTO> movieDTOs = new ArrayList<>();
        for (MovieSaved m : movies) {
            MovieDTO movieDTO = new MovieDTO(m.getId(), m.getTitle(), m.getYear(), m.getImage(), m.getCrew(), m.getImDbRating());
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    public static List<MovieDTO> convertMovieFavoritesToMovieDTO(List<MovieFavorites> movies) {
        List<MovieDTO> movieDTOs = new ArrayList<>();
        for (MovieFavorites m : movies) {
            MovieDTO movieDTO = new MovieDTO(m.getId(), m.getTitle(), m.getYear(), m.getImage(), m.getCrew(), m.getImDbRating());
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }
}
