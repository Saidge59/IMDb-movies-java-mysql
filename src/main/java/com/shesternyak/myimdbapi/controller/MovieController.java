package com.shesternyak.myimdbapi.controller;

import com.shesternyak.myimdbapi.domain.Movie;
import com.shesternyak.myimdbapi.domain.MovieDB;
import com.shesternyak.myimdbapi.dto.MovieDTO;
import com.shesternyak.myimdbapi.service.MovieService;
import com.shesternyak.myimdbapi.service.MoviesFromIMDdService;
import com.shesternyak.myimdbapi.system.Convertor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MovieController {

    MoviesFromIMDdService moviesService;
    MovieService movieService;

    public MovieController(MoviesFromIMDdService moviesService, MovieService movieService) {
        this.moviesService = moviesService;
        this.movieService = movieService;
    }

    @GetMapping("/most-popular-movies")
    public String getMostPopularMovies(Model model) {
        List<Movie> mostPopularMovies = moviesService.getMostPopularMovies();
        List<MovieDTO> tempList = Convertor.convertMovieToMovieDTO(mostPopularMovies);

        List<MovieDB> movieDBList = movieService.getAllMovies();
        List<MovieDTO> repoList = Convertor.convertMovieDBToMovieDTO(movieDBList);

        checkSavedAndFavorites(tempList,  repoList);

        model.addAttribute("movies", tempList);
        return "most-popular-movies";
    }

    @GetMapping("/most-popular-series")
    public String getMostPopularSeries(Model model) {
        List<Movie> mostPopularSeries = moviesService.getMostPopularSeries();
        List<MovieDTO> tempList = Convertor.convertMovieToMovieDTO(mostPopularSeries);

        List<MovieDB> movieDBList = movieService.getAllMovies();
        List<MovieDTO> repoList = Convertor.convertMovieDBToMovieDTO(movieDBList);

        checkSavedAndFavorites(tempList,  repoList);

        model.addAttribute("movies", tempList);
        return "most-popular-series";
    }

    @GetMapping("/top-250-movies")
    public String getTop250Movies(Model model) {
        List<Movie> top250Movies = moviesService.getTop250Movies();
        List<MovieDTO> tempList = Convertor.convertMovieToMovieDTO(top250Movies);

        List<MovieDB> movieDBList = movieService.getAllMovies();
        List<MovieDTO> repoList = Convertor.convertMovieDBToMovieDTO(movieDBList);

        checkSavedAndFavorites(tempList,  repoList);

        model.addAttribute("movies", tempList);
        return "top-250-movies";
    }

    @GetMapping("/top-250-series")
    public String getTop250Series(Model model) {
        List<Movie> top250Series = moviesService.getTop250Series();
        List<MovieDTO> tempList = Convertor.convertMovieToMovieDTO(top250Series);

        List<MovieDB> movieDBList = movieService.getAllMovies();
        List<MovieDTO> repoList = Convertor.convertMovieDBToMovieDTO(movieDBList);

        checkSavedAndFavorites(tempList,  repoList);

        model.addAttribute("movies", tempList);
        return "top-250-series";
    }

    private void checkSavedAndFavorites(List<MovieDTO> tempList, List<MovieDTO> repoList) {
        if (!repoList.isEmpty()) {
            for (MovieDTO t : tempList) {
                for (MovieDTO r : repoList) {
                    if(r.getId().equals(t.getId())) {
                        t.setSaved(r.isSaved());
                        t.setFavorites(r.isFavorites());
                    }
                }
            }
        }
    }
}
