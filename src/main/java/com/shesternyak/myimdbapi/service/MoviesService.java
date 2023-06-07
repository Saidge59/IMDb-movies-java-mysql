package com.shesternyak.myimdbapi.service;

import com.shesternyak.myimdbapi.domain.MovieData;
import com.shesternyak.myimdbapi.dto.MovieDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.shesternyak.myimdbapi.domain.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MoviesService {
    public static final String URI_MOST_POPULAR_MOVIES = "https://imdb-api.com/en/API/MostPopularMovies/k_7qo199gj";
    public static final String URI_MOST_POPULAR_SERIES = "https://imdb-api.com/en/API/MostPopularTVs/k_7qo199gj";
    public static final String URI_TOP_250_MOVIES = "https://imdb-api.com/en/API/Top250Movies/k_7qo199gj";
    public static final String URI_TOP_250_SERIES = "https://imdb-api.com/en/API/Top250TVs/k_7qo199gj";

    private RestTemplate restTemplate;

    public MoviesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> getMostPopularMovies() {
        return getListMovie(URI_MOST_POPULAR_MOVIES);
    }

    public List<Movie> getMostPopularSeries() {
        return getListMovie(URI_MOST_POPULAR_SERIES);
    }

    public List<Movie> getTop250Movies() {
        return getListMovie(URI_TOP_250_MOVIES);
    }

    public List<Movie> getTop250Series() {
        return getListMovie(URI_TOP_250_SERIES);
    }

    private List<Movie> getListMovie(String URI){
        MovieData movieData = restTemplate.getForObject(URI, MovieData.class);
        if (movieData != null) {
            return movieData.getItems();
        }
        throw new NoSuchElementException();
    }

    public List<MovieDTO> convertMovieToMovieDTO(List<Movie> movies){
        List<MovieDTO> movieDTOs = new ArrayList<>();
        for(Movie m : movies){
            movieDTOs.add(new MovieDTO(m));
        }
        return movieDTOs;
    }

    public String parserImage(String str){
        String[] v1S = str.split("_V1_");
        String imageUrl = v1S[0] + "_V1_UX300_CR0,11,300,400_AL_.jpg";
        return imageUrl;
    }
}
