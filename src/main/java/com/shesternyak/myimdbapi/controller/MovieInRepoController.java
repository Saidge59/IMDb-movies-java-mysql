package com.shesternyak.myimdbapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieInRepoController {

    @GetMapping("/saved-movie")
    public String testView(Model model) {
        model.addAttribute("title", "Saved movies");
        model.addAttribute("active", "saved");

        return "list-movies";
    }
}
