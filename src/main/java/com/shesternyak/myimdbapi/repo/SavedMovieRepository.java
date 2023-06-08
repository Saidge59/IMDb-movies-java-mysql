package com.shesternyak.myimdbapi.repo;

import com.shesternyak.myimdbapi.domain.MovieSaved;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedMovieRepository extends JpaRepository<MovieSaved, Integer> {
    void deleteByTitle(String title);
}