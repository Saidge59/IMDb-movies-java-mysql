package com.shesternyak.myimdbapi.repo;

import com.shesternyak.myimdbapi.domain.MovieFavorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesMovieRepository extends JpaRepository<MovieFavorites, Integer> {
}