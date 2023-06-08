package com.shesternyak.myimdbapi.service.registration;

import com.shesternyak.myimdbapi.domain.Roles;
import com.shesternyak.myimdbapi.domain.registration.Role;

public interface RoleService {
    public Role findUserByName(Roles roles);
}
