package com.shesternyak.myimdbapi.controller;

import com.shesternyak.myimdbapi.domain.Movie;
import com.shesternyak.myimdbapi.dto.MovieDTO;
import com.shesternyak.myimdbapi.service.MoviesService;
import com.shesternyak.myimdbapi.system.Convertor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieControllerTest {

    @Test
    void getTestMoviesTest() throws Exception {
        MoviesService mockMoviesService = mock(MoviesService.class);
        MovieController controller = new MovieController(mockMoviesService);

        Model mockModel = mock(Model.class);
        List<Movie> fakeMovies = createFakeMovies();
        List<MovieDTO> movieDTO = Convertor.convertMovieToMovieDTO(fakeMovies);
        String viewName = controller.testView(mockModel);

        assertEquals("list-movies", viewName);
        Mockito.verify(mockModel).addAttribute("movies", movieDTO);
        Mockito.verify(mockModel).addAttribute("title", "Test movies");
    }

    @Test
    void getMostPopularMoviesTest() throws Exception {
        MoviesService mockMoviesService = mock(MoviesService.class);
        MovieController controller = new MovieController(mockMoviesService);

        Model mockModel = mock(Model.class);
        List<Movie> fakeMovies = createFakeMovies();
        List<MovieDTO> movieDTO = Convertor.convertMovieToMovieDTO(fakeMovies);

        when(mockMoviesService.getMostPopularMovies()).thenReturn(fakeMovies);

        String viewName = controller.getMostPopularMovies(mockModel);

        assertEquals("list-movies", viewName);
        Mockito.verify(mockModel).addAttribute("movies", movieDTO);
        Mockito.verify(mockModel).addAttribute("title", "Most popular movies");
    }

    @Test
    void getMostPopularSeries() throws Exception {
        MoviesService mockMoviesService = mock(MoviesService.class);
        MovieController controller = new MovieController(mockMoviesService);

        Model mockModel = mock(Model.class);
        List<Movie> fakeMovies = createFakeMovies();
        List<MovieDTO> movieDTO = Convertor.convertMovieToMovieDTO(fakeMovies);

        when(mockMoviesService.getMostPopularSeries()).thenReturn(fakeMovies);

        String viewName = controller.getMostPopularSeries(mockModel);

        assertEquals("list-movies", viewName);
        Mockito.verify(mockModel).addAttribute("movies", movieDTO);
        Mockito.verify(mockModel).addAttribute("title", "Most popular series");
    }

    @Test
    void getTop250Movies() throws Exception {
        MoviesService mockMoviesService = mock(MoviesService.class);
        MovieController controller = new MovieController(mockMoviesService);

        Model mockModel = mock(Model.class);
        List<Movie> fakeMovies = createFakeMovies();
        List<MovieDTO> top250DTO = Convertor.convertMovieToMovieDTO(fakeMovies);

        when(mockMoviesService.getTop250Movies()).thenReturn(fakeMovies);

        String viewName = controller.getTop250Movies(mockModel);

        assertEquals("list-movies", viewName);
        Mockito.verify(mockModel).addAttribute("movies", top250DTO);
        Mockito.verify(mockModel).addAttribute("title", "Top 250 movies");
    }

    @Test
    void getTop250Series() throws Exception {
        MoviesService mockMoviesService = mock(MoviesService.class);
        MovieController controller = new MovieController(mockMoviesService);

        Model mockModel = mock(Model.class);
        List<Movie> fakeMovies = createFakeMovies();
        List<MovieDTO> top250DTO = Convertor.convertMovieToMovieDTO(fakeMovies);

        when(mockMoviesService.getTop250Series()).thenReturn(fakeMovies);

        String viewName = controller.getTop250Series(mockModel);

        assertEquals("list-movies", viewName);
        Mockito.verify(mockModel).addAttribute("movies", top250DTO);
        Mockito.verify(mockModel).addAttribute("title", "Top 250 series");
    }

    private List<Movie> createFakeMovies() {
        Movie movie1 = new Movie("tt5971474", "The Little Mermaid", 2023, "https://m.media-amazon.com/images/M/MV5BYTUxYjczMWUtYzlkZC00NTcwLWE3ODQtN2I2YTIxOTU0ZTljXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX300_CR0,11,300,400_AL_.jpg", "Rob Marshall (dir.), Halle Bailey, Jonah Hauer-King", 7.2f);
        Movie movie2 = new Movie("tt9362722", "Spider-Man: Across the Spider-Verse", 2023, "https://m.media-amazon.com/images/M/MV5BNzQ1ODUzYjktMzRiMS00ODNiLWI4NzQtOTRiN2VlNTNmODFjXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX300_CR0,11,300,400_AL_.jpg", "Joaquim Dos Santos (dir.), Shameik Moore, Hailee Steinfeld", 9.1f);
        Movie movie3 = new Movie("tt10366206", "John Wick: Chapter 4", 2023, "https://m.media-amazon.com/images/M/MV5BMDExZGMyOTMtMDgyYi00NGIwLWJhMTEtOTdkZGFjNmZiMTEwXkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_UX300_CR0,11,300,400_AL_.jpg", "Chad Stahelski (dir.), Keanu Reeves, Laurence Fishburne", 8.0f);
        Movie movie4 = new Movie("tt1517268", "Barbie", 2023, "https://m.media-amazon.com/images/M/MV5BOWIwZGY0OTYtZjUzYy00NzRmLTg5YzgtYWMzNWQ0MmZiY2MwXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_UX300_CR0,11,300,400_AL_.jpg", "Greta Gerwig (dir.), Margot Robbie, Ryan Gosling", 0.0f);

        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        return movies;
    }
}