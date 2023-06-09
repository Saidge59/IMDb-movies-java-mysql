package com.shesternyak.myimdbapi.controller;

import com.shesternyak.myimdbapi.domain.MovieDB;
import com.shesternyak.myimdbapi.dto.MovieDTO;
import com.shesternyak.myimdbapi.service.MovieService;
import com.shesternyak.myimdbapi.system.Convertor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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

        Optional<MovieDB> byId = movieService.getById(movieDTO.getId());
        switch (action) {
            case "saved":
                if (byId.isPresent()) {
                    MovieDB movieDB = byId.get();
                    movieDTO.setFavorites(movieDB.isFavorites());
                }
                movieDTO.setSaved(true);
                movieService.saveMovies(movieDTO);
                return "redirect:/saved";
            case "favorites":
                if (byId.isPresent()) {
                    MovieDB movieDB = byId.get();
                    movieDTO.setSaved(movieDB.isSaved());
                }
                movieDTO.setFavorites(true);
                movieService.saveMovies(movieDTO);
                return "redirect:/favorites";
            case "delete":
                if (byId.isPresent()) {
                    MovieDB movieDB = byId.get();
                    if (!movieDB.isFavorites()) {
                        movieService.deleteMovies(movieDTO);
                    } else {
                        movieDTO.setFavorites(true);
                        movieDTO.setSaved(false);
                        movieService.saveMovies(movieDTO);
                    }
                }
                return "redirect:/saved";
            case "no_favorites":
                if (byId.isPresent()) {
                    MovieDB movieDB = byId.get();
                    if (!movieDB.isSaved()) {
                        movieService.deleteMovies(movieDTO);
                    } else {
                        movieDTO.setSaved(true);
                        movieDTO.setFavorites(false);
                        movieService.saveMovies(movieDTO);
                    }
                }
                return "redirect:/favorites";
            default:
                throw new IllegalArgumentException();
        }
    }

    @GetMapping(value = "/saved")
    public String saved(Model model) {
        List<MovieDTO> listMovieDTO = getListMovieDTO(MovieDB::isSaved);
        model.addAttribute("movies", listMovieDTO);
        model.addAttribute("title", "Saved movies");
        model.addAttribute("active", "saved");
        return "list-movies";
    }

    @GetMapping(value = "/favorites")
    public String favorites(Model model) {
        List<MovieDTO> listMovieDTO = getListMovieDTO(MovieDB::isFavorites);
        model.addAttribute("movies", listMovieDTO);
        model.addAttribute("title", "Favorites movies");
        model.addAttribute("active", "favorites");
        return "list-movies";
    }

    private List<MovieDTO> getListMovieDTO(Predicate<MovieDB> predicate) {
        List<MovieDB> allMovies = movieService.getAllMovies();
        List<MovieDTO> mpmDTO = Collections.emptyList();

        if (allMovies != null) {
            allMovies = allMovies.stream().filter(predicate).toList();
            mpmDTO = Convertor.convertMovieDBToMovieDTO(allMovies);
        }

        return mpmDTO;
    }

}
