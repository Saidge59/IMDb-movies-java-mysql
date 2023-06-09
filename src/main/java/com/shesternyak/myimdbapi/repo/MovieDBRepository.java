package com.shesternyak.myimdbapi.repo;

import com.shesternyak.myimdbapi.domain.MovieDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDBRepository extends JpaRepository<MovieDB, String> {
    MovieDB getById(String id);
    void deleteById(String id);
}