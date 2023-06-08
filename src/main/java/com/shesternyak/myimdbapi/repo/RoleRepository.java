package com.shesternyak.myimdbapi.repo;

import com.example.films_ratings.entity.registration.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}
