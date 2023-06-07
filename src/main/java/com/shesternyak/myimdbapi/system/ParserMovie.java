package com.shesternyak.myimdbapi.system;

import com.shesternyak.myimdbapi.domain.Movie;

import java.util.List;

public class ParserMovie {
    public static void parserImage(List<Movie> movies) {
        for (Movie movie : movies) {
            String[] v1S = movie.getImage().split("_V1_");
            String imageUrl = v1S[0] + "_V1_UX300_CR0,11,300,400_AL_.jpg";
            movie.setImage(imageUrl);
        }
    }
}
