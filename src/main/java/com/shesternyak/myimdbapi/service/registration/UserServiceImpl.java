package com.shesternyak.myimdbapi.service.registration;

import com.shesternyak.myimdbapi.domain.Roles;
import com.shesternyak.myimdbapi.domain.registration.Role;
import com.shesternyak.myimdbapi.domain.registration.User;
import com.shesternyak.myimdbapi.dto.UserRegistrationDTO;
import com.shesternyak.myimdbapi.repo.RoleRepository;
import com.shesternyak.myimdbapi.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findByEmail(String name) { return userRepository.findByEmail(name);}

    @Override
    public User save(UserRegistrationDTO registrationDTO) {

        Role role = roleRepository.findByName(Roles.USER.name());
        if(role == null) {
            role = new Role(Roles.USER.name());
        }

        User user = new User(
                registrationDTO.getName(),
                registrationDTO.getEmail(),
                passwordEncoder.encode(registrationDTO.getPassword()),
                Arrays.asList(role));

        return userRepository.save(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
