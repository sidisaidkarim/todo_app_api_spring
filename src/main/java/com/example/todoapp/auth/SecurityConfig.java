package com.example.todoapp.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtConverter jwtConverter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //any request should be authenticated
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorizeHttpRequests ->
                        authorizeHttpRequests.anyRequest().authenticated());

        // utiliser l'authentification avec jwt
        http
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtConverter);

        //utiliser l'auth stateless qui permet d'avoir toute les info de user dans la requete(jwt)
        // sans etre oblige de creer une session cote serveur pour les stocker
        http
                .sessionManagement()
                .sessionCreationPolicy(STATELESS);

        return http.build();
    }
}
