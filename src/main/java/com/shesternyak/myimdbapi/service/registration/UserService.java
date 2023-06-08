package com.shesternyak.myimdbapi.service.registration;

import com.shesternyak.myimdbapi.domain.registration.User;
import com.shesternyak.myimdbapi.dto.UserRegistrationDTO;

public interface UserService {
    public User save(UserRegistrationDTO registrationDTO);
    public User save(User user);
    public void delete(User user);

    public User findUserByName(String name);
    public User findByEmail(String name);
}
