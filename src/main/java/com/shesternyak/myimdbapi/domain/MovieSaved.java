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
@Table(name = "saved_movies")
public class MovieSaved {
    @Id
    private String id;
    private String title;
    private int year;
    private String image;
    private String crew;
    private float imDbRating;
}