package com.shesternyak.myimdbapi.controller;

import com.shesternyak.myimdbapi.domain.MovieDB;
import com.shesternyak.myimdbapi.dto.MovieDTO;
import com.shesternyak.myimdbapi.service.MovieService;
import com.shesternyak.myimdbapi.system.Convertor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieInRepoControllerTest {

    @Mock
    MovieService mockMoviesService;

    @InjectMocks
    private MovieInRepoController controller = new MovieInRepoController(mockMoviesService);

    @BeforeEach
    public void init() { MockitoAnnotations.openMocks(this); }

    @Test
    void updateMPMRepo() {
        MovieDB fakeMovie = fakeMovie();
        MovieDTO movieDTO = Convertor.convertMovieDBToMovieDTO(fakeMovie);

        when(mockMoviesService.getById(any(String.class))).thenReturn(fakeMovie);
        when(mockMoviesService.saveMovies(any(MovieDB.class))).thenReturn(fakeMovie);

        String viewName = controller.updateMPMRepo("saved", movieDTO);

        assertEquals("redirect:/most-popular-movies", viewName);
    }

    @Test
    void updateMPSRepo() {
        MovieDB fakeMovie = fakeMovie();
        MovieDTO movieDTO = Convertor.convertMovieDBToMovieDTO(fakeMovie);

        when(mockMoviesService.getById(any(String.class))).thenReturn(fakeMovie);
        when(mockMoviesService.saveMovies(any(MovieDB.class))).thenReturn(fakeMovie);

        String viewName = controller.updateMPSRepo("saved", movieDTO);

        assertEquals("redirect:/most-popular-series", viewName);
    }

    @Test
    void updateT250MRepo() {
        MovieDB fakeMovie = fakeMovie();
        MovieDTO movieDTO = Convertor.convertMovieDBToMovieDTO(fakeMovie);

        when(mockMoviesService.getById(any(String.class))).thenReturn(fakeMovie);
        when(mockMoviesService.saveMovies(any(MovieDB.class))).thenReturn(fakeMovie);

        String viewName = controller.updateT250MRepo("saved", movieDTO);

        assertEquals("redirect:/top-250-movies", viewName);
    }

    @Test
    void updateT250SRepo() {
        MovieDB fakeMovie = fakeMovie();
        MovieDTO movieDTO = Convertor.convertMovieDBToMovieDTO(fakeMovie);

        when(mockMoviesService.getById(any(String.class))).thenReturn(fakeMovie);
        when(mockMoviesService.saveMovies(any(MovieDB.class))).thenReturn(fakeMovie);

        String viewName = controller.updateT250SRepo("saved", movieDTO);

        assertEquals("redirect:/top-250-series", viewName);
    }

    @Test
    void updateSavedRepo() {
        MovieDB fakeMovie = fakeMovie();
        MovieDTO movieDTO = Convertor.convertMovieDBToMovieDTO(fakeMovie);

        when(mockMoviesService.getById(any(String.class))).thenReturn(fakeMovie);
        when(mockMoviesService.saveMovies(any(MovieDB.class))).thenReturn(fakeMovie);

        String viewName = controller.updateSavedRepo("saved", movieDTO);

        assertEquals("redirect:/saved", viewName);
    }

    @Test
    void updateFavoritesRepo() {
        MovieDB fakeMovie = fakeMovie();
        MovieDTO movieDTO = Convertor.convertMovieDBToMovieDTO(fakeMovie);

        when(mockMoviesService.getById(any(String.class))).thenReturn(fakeMovie);
        when(mockMoviesService.saveMovies(any(MovieDB.class))).thenReturn(fakeMovie);

        String viewName = controller.updateFavoritesRepo("saved", movieDTO);

        assertEquals("redirect:/favorites", viewName);
    }

    @Test
    void saved() {
        Model mockModel = mock(Model.class);

        List<MovieDTO> listMovieDTO = fakeMoviesDTO();
        when(mockMoviesService.getListMovieDTO(any(Predicate.class))).thenReturn(listMovieDTO);

        String viewName = controller.saved(mockModel);

        assertEquals("saved", viewName);
        Mockito.verify(mockModel).addAttribute("movies", listMovieDTO);
    }

    @Test
    void favorites() {
        Model mockModel = mock(Model.class);

        List<MovieDTO> listMovieDTO = fakeMoviesDTO();
        when(mockMoviesService.getListMovieDTO(any(Predicate.class))).thenReturn(listMovieDTO);

        String viewName = controller.favorites(mockModel);

        assertEquals("favorites", viewName);
        Mockito.verify(mockModel).addAttribute("movies", listMovieDTO);
    }

    private MovieDB fakeMovie() {
        MovieDB movie = new MovieDB("tt5971474", "The Little Mermaid", 2023, "https://m.media-amazon.com/images/M/MV5BYTUxYjczMWUtYzlkZC00NTcwLWE3ODQtN2I2YTIxOTU0ZTljXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX300_CR0,11,300,400_AL_.jpg", "Rob Marshall (dir.), Halle Bailey, Jonah Hauer-King", 7.2f, false, false);
        return movie;
    }

    private List<MovieDTO> fakeMoviesDTO() {
        MovieDTO movie1 = new MovieDTO("tt5971474", "The Little Mermaid", 2023, "https://m.media-amazon.com/images/M/MV5BYTUxYjczMWUtYzlkZC00NTcwLWE3ODQtN2I2YTIxOTU0ZTljXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX300_CR0,11,300,400_AL_.jpg", "Rob Marshall (dir.), Halle Bailey, Jonah Hauer-King", 7.2f);
        MovieDTO movie2 = new MovieDTO("tt9362722", "Spider-Man: Across the Spider-Verse", 2023, "https://m.media-amazon.com/images/M/MV5BNzQ1ODUzYjktMzRiMS00ODNiLWI4NzQtOTRiN2VlNTNmODFjXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX300_CR0,11,300,400_AL_.jpg", "Joaquim Dos Santos (dir.), Shameik Moore, Hailee Steinfeld", 9.1f);
        MovieDTO movie3 = new MovieDTO("tt10366206", "John Wick: Chapter 4", 2023, "https://m.media-amazon.com/images/M/MV5BMDExZGMyOTMtMDgyYi00NGIwLWJhMTEtOTdkZGFjNmZiMTEwXkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_UX300_CR0,11,300,400_AL_.jpg", "Chad Stahelski (dir.), Keanu Reeves, Laurence Fishburne", 8.0f);
        MovieDTO movie4 = new MovieDTO("tt1517268", "Barbie", 2023, "https://m.media-amazon.com/images/M/MV5BOWIwZGY0OTYtZjUzYy00NzRmLTg5YzgtYWMzNWQ0MmZiY2MwXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_UX300_CR0,11,300,400_AL_.jpg", "Greta Gerwig (dir.), Margot Robbie, Ryan Gosling", 0.0f);

        List<MovieDTO> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        return movies;
    }
}