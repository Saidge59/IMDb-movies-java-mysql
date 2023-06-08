package com.shesternyak.myimdbapi.service.registration;

import com.shesternyak.myimdbapi.domain.Roles;
import com.shesternyak.myimdbapi.domain.registration.Role;
import com.shesternyak.myimdbapi.repo.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findUserByName(Roles roles) {
        return roleRepository.findByName(roles.name());
    }
}
