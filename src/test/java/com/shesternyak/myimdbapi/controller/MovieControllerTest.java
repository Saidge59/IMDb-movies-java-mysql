package com.shesternyak.myimdbapi.controller;

import com.shesternyak.myimdbapi.domain.Movie;
import com.shesternyak.myimdbapi.domain.MovieDB;
import com.shesternyak.myimdbapi.dto.MovieDTO;
import com.shesternyak.myimdbapi.service.MovieService;
import com.shesternyak.myimdbapi.service.MoviesFromIMDdService;
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
    void getMostPopularMoviesTest() throws Exception {
        Model mockModel = mock(Model.class);
        MoviesFromIMDdService imDdService = mock(MoviesFromIMDdService.class);
        MovieService mockMoviesService = mock(MovieService.class);

        MovieController controller = new MovieController(imDdService, mockMoviesService);

        List<Movie> fakeMovies = createFakeMovies();
        List<MovieDB> fakeMoviesDB = createFakeMoviesDB();

        List<MovieDTO> tempList = Convertor.convertMovieToMovieDTO(fakeMovies);

        when(imDdService.getMostPopularMovies()).thenReturn(fakeMovies);
        when(mockMoviesService.getAllMovies()).thenReturn(fakeMoviesDB);

        String viewName = controller.getMostPopularMovies(mockModel);

        assertEquals("most-popular-movies", viewName);
        Mockito.verify(mockModel).addAttribute("movies", tempList);
    }

    @Test
    void getMostPopularSeries() throws Exception {
        Model mockModel = mock(Model.class);
        MoviesFromIMDdService imDdService = mock(MoviesFromIMDdService.class);
        MovieService mockMoviesService = mock(MovieService.class);

        MovieController controller = new MovieController(imDdService, mockMoviesService);

        List<Movie> fakeMovies = createFakeMovies();
        List<MovieDB> fakeMoviesDB = createFakeMoviesDB();

        List<MovieDTO> tempList = Convertor.convertMovieToMovieDTO(fakeMovies);

        when(imDdService.getMostPopularSeries()).thenReturn(fakeMovies);
        when(mockMoviesService.getAllMovies()).thenReturn(fakeMoviesDB);

        String viewName = controller.getMostPopularSeries(mockModel);

        assertEquals("most-popular-series", viewName);
        Mockito.verify(mockModel).addAttribute("movies", tempList);
    }

    @Test
    void getTop250Movies() throws Exception {
        Model mockModel = mock(Model.class);
        MoviesFromIMDdService imDdService = mock(MoviesFromIMDdService.class);
        MovieService mockMoviesService = mock(MovieService.class);

        MovieController controller = new MovieController(imDdService, mockMoviesService);

        List<Movie> fakeMovies = createFakeMovies();
        List<MovieDB> fakeMoviesDB = createFakeMoviesDB();

        List<MovieDTO> tempList = Convertor.convertMovieToMovieDTO(fakeMovies);

        when(imDdService.getTop250Movies()).thenReturn(fakeMovies);
        when(mockMoviesService.getAllMovies()).thenReturn(fakeMoviesDB);

        String viewName = controller.getTop250Movies(mockModel);

        assertEquals("top-250-movies", viewName);
        Mockito.verify(mockModel).addAttribute("movies", tempList);
    }

    @Test
    void getTop250Series() throws Exception {
        Model mockModel = mock(Model.class);
        MoviesFromIMDdService imDdService = mock(MoviesFromIMDdService.class);
        MovieService mockMoviesService = mock(MovieService.class);

        MovieController controller = new MovieController(imDdService, mockMoviesService);

        List<Movie> fakeMovies = createFakeMovies();
        List<MovieDB> fakeMoviesDB = createFakeMoviesDB();

        List<MovieDTO> tempList = Convertor.convertMovieToMovieDTO(fakeMovies);

        when(imDdService.getTop250Series()).thenReturn(fakeMovies);
        when(mockMoviesService.getAllMovies()).thenReturn(fakeMoviesDB);

        String viewName = controller.getTop250Series(mockModel);

        assertEquals("top-250-series", viewName);
        Mockito.verify(mockModel).addAttribute("movies", tempList);
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
    private List<MovieDB> createFakeMoviesDB() {
        MovieDB movie1 = new MovieDB("tt5971474", "The Little Mermaid", 2023, "https://m.media-amazon.com/images/M/MV5BYTUxYjczMWUtYzlkZC00NTcwLWE3ODQtN2I2YTIxOTU0ZTljXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX300_CR0,11,300,400_AL_.jpg", "Rob Marshall (dir.), Halle Bailey, Jonah Hauer-King", 7.2f);
        MovieDB movie2 = new MovieDB("tt9362722", "Spider-Man: Across the Spider-Verse", 2023, "https://m.media-amazon.com/images/M/MV5BNzQ1ODUzYjktMzRiMS00ODNiLWI4NzQtOTRiN2VlNTNmODFjXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX300_CR0,11,300,400_AL_.jpg", "Joaquim Dos Santos (dir.), Shameik Moore, Hailee Steinfeld", 9.1f);
        MovieDB movie3 = new MovieDB("tt10366206", "John Wick: Chapter 4", 2023, "https://m.media-amazon.com/images/M/MV5BMDExZGMyOTMtMDgyYi00NGIwLWJhMTEtOTdkZGFjNmZiMTEwXkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_UX300_CR0,11,300,400_AL_.jpg", "Chad Stahelski (dir.), Keanu Reeves, Laurence Fishburne", 8.0f);
        MovieDB movie4 = new MovieDB("tt1517268", "Barbie", 2023, "https://m.media-amazon.com/images/M/MV5BOWIwZGY0OTYtZjUzYy00NzRmLTg5YzgtYWMzNWQ0MmZiY2MwXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_UX300_CR0,11,300,400_AL_.jpg", "Greta Gerwig (dir.), Margot Robbie, Ryan Gosling", 0.0f);

        List<MovieDB> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        return movies;
    }
}