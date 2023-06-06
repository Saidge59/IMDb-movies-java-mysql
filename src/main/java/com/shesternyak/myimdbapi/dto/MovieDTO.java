package com.shesternyak.myimdbapi.dto;

import com.shesternyak.myimdbapi.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private String id;
    private String title;
    private int year;
    private String image;
    private String crew;
    private float imDbRating;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.year = movie.getYear();
        this.image = movie.getImage();
        this.crew = movie.getCrew();
        this.imDbRating = movie.getImDbRating();
    }
}
