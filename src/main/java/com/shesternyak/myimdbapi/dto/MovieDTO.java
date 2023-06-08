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

    public MovieDTO(String id, String title, int year, String image, String crew, float imDbRating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.image = image;
        this.crew = crew;
        this.imDbRating = imDbRating;
    }

    private boolean isSaved;
    private boolean isFavorites;
}
