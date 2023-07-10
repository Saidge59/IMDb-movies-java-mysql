package com.shesternyak.myimdbapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity()
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(
                        (requests) -> requests
                                .requestMatchers(
                                        "/",
                                        "/css/**",
                                        "/test-movie",
                                        "/registration",
                                        "/most-popular-movies",
                                        "/most-popular-series",
                                        "/top-250-movies",
                                        "/top-250-series",
                                        "/movie-list"
                                ).permitAll()
                                .anyRequest().authenticated())
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/test-movie")
                        .permitAll())
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
}
