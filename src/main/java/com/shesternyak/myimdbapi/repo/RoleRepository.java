package com.shesternyak.myimdbapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shesternyak.myimdbapi.domain.registration.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}
