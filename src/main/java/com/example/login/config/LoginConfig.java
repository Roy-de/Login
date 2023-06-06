package com.example.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class LoginConfig {
    @Bean
    @Order(100)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .securityMatcher("/user")
                .authorizeHttpRequests((authConfig)-> authConfig
                        .requestMatchers("/user/**").hasAnyAuthority("ROLE_USER")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
    @Bean
    @Order(101)
    public SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception{
        http
                .securityMatcher("/admin")
                .authorizeHttpRequests((authConfig)-> authConfig
                        .requestMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
