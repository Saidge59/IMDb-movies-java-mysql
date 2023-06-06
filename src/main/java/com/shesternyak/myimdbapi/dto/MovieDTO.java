package com.shesternyak.myimdbapi.dto;

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
}
