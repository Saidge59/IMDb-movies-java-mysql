package com.shesternyak.myimdbapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {
    private String id;
    private String title;
    private int year;
    private String image;
    private String crew;
    private float imDbRating;
}
