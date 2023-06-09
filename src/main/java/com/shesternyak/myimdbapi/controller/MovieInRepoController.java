package com.shesternyak.myimdbapi.controller;

import com.shesternyak.myimdbapi.domain.MovieDB;
import com.shesternyak.myimdbapi.dto.MovieDTO;
import com.shesternyak.myimdbapi.service.MovieService;
import com.shesternyak.myimdbapi.system.Convertor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieInRepoController {

    MovieService movieService;

    public MovieInRepoController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(value = "/most-popular-movies")
    public String updateMPMRepo(
            @RequestParam("action") String action,
            @ModelAttribute("movie") MovieDTO movieDTO) {

        actionWithRepo(action, movieDTO);

        return "redirect:/most-popular-movies";
    }
    @PostMapping(value = "/most-popular-series")
    public String updateMPSRepo(
            @RequestParam("action") String action,
            @ModelAttribute("movie") MovieDTO movieDTO) {

        actionWithRepo(action, movieDTO);

        return "redirect:/most-popular-series";
    }
    @PostMapping(value = "/top-250-movies")
    public String updateT250MRepo(
            @RequestParam("action") String action,
            @ModelAttribute("movie") MovieDTO movieDTO) {

        actionWithRepo(action, movieDTO);

        return "redirect:/top-250-movies";
    }
    @PostMapping(value = "/top-250-series")
    public String updateT250SRepo(
            @RequestParam("action") String action,
            @ModelAttribute("movie") MovieDTO movieDTO) {

        actionWithRepo(action, movieDTO);

        return "redirect:/top-250-series";
    }

    @PostMapping(value = "/saved")
    public String updateSavedRepo(
            @RequestParam("action") String action,
            @ModelAttribute("movie") MovieDTO movieDTO) {

        actionWithRepo(action, movieDTO);

        return "redirect:/saved";
    }

    @PostMapping(value = "/favorites")
    public String updateFavoritesRepo(
            @RequestParam("action") String action,
            @ModelAttribute("movie") MovieDTO movieDTO) {

        actionWithRepo(action, movieDTO);

        return "redirect:/favorites";
    }

    @GetMapping(value = "/saved")
    public String saved(Model model) {
        List<MovieDTO> listMovieDTO = movieService.getListMovieDTO(MovieDB::isSaved);
        model.addAttribute("movies", listMovieDTO);
        return "saved";
    }

    @GetMapping(value = "/favorites")
    public String favorites(Model model) {
        List<MovieDTO> listMovieDTO = movieService.getListMovieDTO(MovieDB::isFavorites);
        model.addAttribute("movies", listMovieDTO);
        return "favorites";
    }

    private void actionWithRepo(String action, MovieDTO movieDTO){
        MovieDB movie = movieService.getById(movieDTO.getId());
        movieDTO.setSaved(movie.isSaved());
        movieDTO.setFavorites(movie.isFavorites());

        switch (action) {
            case "saved":
                movieDTO.setSaved(true);
                movieService.saveMovies(Convertor.convertMovieDTOToMovieDB(movieDTO));
                break;
            case "favorites":
                movieDTO.setFavorites(true);
                movieService.saveMovies(Convertor.convertMovieDTOToMovieDB(movieDTO));
                break;
            case "delete":
                if (!movieDTO.isFavorites()) {
                    movieService.deleteMovies(Convertor.convertMovieDTOToMovieDB(movieDTO));
                } else {
                    movieDTO.setSaved(false);
                    movieService.saveMovies(Convertor.convertMovieDTOToMovieDB(movieDTO));
                }
                break;
            case "no_favorites":
                if (!movieDTO.isSaved()) {
                    movieService.deleteMovies(Convertor.convertMovieDTOToMovieDB(movieDTO));
                } else {
                    movieDTO.setFavorites(false);
                    movieService.saveMovies(Convertor.convertMovieDTOToMovieDB(movieDTO));
                }
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

}
