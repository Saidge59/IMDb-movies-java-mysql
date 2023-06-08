package com.shesternyak.myimdbapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(
                        (requests) -> requests
                                .requestMatchers(
                                        "/",
                                        "/most-popular-movies",
                                        "/most-popular-series",
                                        "/top-250-movie",
                                        "/top-250-series"
                                ).permitAll()
                                .anyRequest().authenticated())
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/most-popular-movies")
                        .permitAll())
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
}
