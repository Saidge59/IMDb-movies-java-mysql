package com.shesternyak.myimdbapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

    @RequestMapping("/most-popular-movies")
    public String getMostPopularMovies(){
        return "most-popular-movies";
    }
}
