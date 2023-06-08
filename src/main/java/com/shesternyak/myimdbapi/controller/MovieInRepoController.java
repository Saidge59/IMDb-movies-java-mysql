package com.shesternyak.myimdbapi.controller;

import com.shesternyak.myimdbapi.domain.Movie;
import com.shesternyak.myimdbapi.domain.MovieFavorites;
import com.shesternyak.myimdbapi.domain.MovieSaved;
import com.shesternyak.myimdbapi.dto.MovieDTO;
import com.shesternyak.myimdbapi.dto.UserRegistrationDTO;
import com.shesternyak.myimdbapi.service.MovieService;
import com.shesternyak.myimdbapi.system.Convertor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieInRepoController {

    MovieService movieService;

    public MovieInRepoController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(value = "/movie-list")
    public String updateToMySaved(
            @RequestParam("action") String action,
            @ModelAttribute("movie") MovieDTO movieDTO,
            RedirectAttributes redirectAttributes) {

        switch (action) {
            case "saved":
                movieService.saveSavedMovies(movieDTO);
                redirectAttributes.addFlashAttribute("title", "Saved movies");
                redirectAttributes.addFlashAttribute("active", "saved");
                return "redirect:/saved";
            case "favorites":
                movieService.saveFavoritesMovies(movieDTO);
                redirectAttributes.addFlashAttribute("title", "Favorites movies");
                redirectAttributes.addFlashAttribute("active", "favorites");
                return "redirect:/favorites";
            default:
                throw new IllegalArgumentException();
        }
    }

    @GetMapping(value = "/saved")
    public String saved(Model model) {
        List<MovieSaved> allMovies = movieService.getAllSavedMovies();

        if (allMovies != null) {
            List<MovieDTO> mpmDTO = Convertor.convertMovieSavedToMovieDTO(allMovies);
            model.addAttribute("movies", mpmDTO);
        } else {
            model.addAttribute("movies", new ArrayList<MovieDTO>());
        }

        model.addAttribute("title", "Saved movies");
        model.addAttribute("active", "saved");
        return "list-movies";
    }

    @GetMapping(value = "/favorites")
    public String favorites(Model model) {
        List<MovieFavorites> allMovies = movieService.getAllFavoritesMovies();

        if (allMovies != null) {
            List<MovieDTO> mpmDTO = Convertor.convertMovieFavoritesToMovieDTO(allMovies);
            model.addAttribute("movies", mpmDTO);
        } else {
            model.addAttribute("movies", new ArrayList<MovieDTO>());
        }

        model.addAttribute("title", "Favorites movies");
        model.addAttribute("active", "favorites");
        return "list-movies";
    }

}
