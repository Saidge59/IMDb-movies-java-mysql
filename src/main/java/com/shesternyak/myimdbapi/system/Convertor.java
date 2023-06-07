package com.shesternyak.myimdbapi.system;

import com.shesternyak.myimdbapi.domain.Movie;
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
}
