package com.shesternyak.myimdbapi.controller;

import com.shesternyak.myimdbapi.dto.MovieDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {

    @RequestMapping("/most-popular-movies")
    public String getMostPopularMovies(Model model) {
        MovieDTO movie1 = new MovieDTO("tt5971474", "The Little Mermaid", 2023, "https://m.media-amazon.com/images/M/MV5BYTUxYjczMWUtYzlkZC00NTcwLWE3ODQtN2I2YTIxOTU0ZTljXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_Ratio0.6716_AL_.jpg", "Rob Marshall (dir.), Halle Bailey, Jonah Hauer-King", 7.2f);
        MovieDTO movie2 = new MovieDTO("tt9362722", "Spider-Man: Across the Spider-Verse", 2023, "https://m.media-amazon.com/images/M/MV5BNzQ1ODUzYjktMzRiMS00ODNiLWI4NzQtOTRiN2VlNTNmODFjXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_Ratio0.6716_AL_.jpg", "Joaquim Dos Santos (dir.), Shameik Moore, Hailee Steinfeld", 9.1f);
        MovieDTO movie3 = new MovieDTO("tt10366206", "John Wick: Chapter 4", 2023, "https://m.media-amazon.com/images/M/MV5BMDExZGMyOTMtMDgyYi00NGIwLWJhMTEtOTdkZGFjNmZiMTEwXkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_Ratio0.6716_AL_.jpg", "Chad Stahelski (dir.), Keanu Reeves, Laurence Fishburne", 8.0f);
        MovieDTO movie4 = new MovieDTO("tt1517268", "Barbie", 2023, "https://m.media-amazon.com/images/M/MV5BOWIwZGY0OTYtZjUzYy00NzRmLTg5YzgtYWMzNWQ0MmZiY2MwXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_Ratio0.6716_AL_.jpg", "Greta Gerwig (dir.), Margot Robbie, Ryan Gosling", 0.0f);

        List<MovieDTO> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);

        model.addAttribute("movies", movies);
        return "most-popular-movies";
    }
}
