package com.shesternyak.myimdbapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "movies_db")
public class MovieDB {
    @Id
    private String id;
    private String title;
    private int year;
    private String image;
    private String crew;
    private float imDbRating;
    private boolean isSaved;
    private boolean isFavorites;

    public MovieDB(String id, String title, int year, String image, String crew, float imDbRating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.image = image;
        this.crew = crew;
        this.imDbRating = imDbRating;
    }
}
