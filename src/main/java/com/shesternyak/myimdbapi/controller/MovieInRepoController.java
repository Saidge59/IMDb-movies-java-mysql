package com.shesternyak.myimdbapi.controller;

import com.shesternyak.myimdbapi.dto.MovieDTO;
import com.shesternyak.myimdbapi.dto.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieInRepoController {

    @RequestMapping(value = "/movie-list")
    public String addToMySaved(
            @RequestParam("action") String action,
            @ModelAttribute("movie") MovieDTO movieDTO,
            Model model) {

        System.out.println(action);
        System.out.println(movieDTO);

        switch (action) {
            case "saved":
                model.addAttribute("title", "Saved movies");
                model.addAttribute("active", "saved");
                break;
            case "favorites":
                model.addAttribute("title", "Favorites movies");
                model.addAttribute("active", "favorites");
                break;
        }

        return "list-movies";
    }

}
