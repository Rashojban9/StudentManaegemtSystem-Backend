package com.rashoj.StudentManagementSystemTeacher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        return httpSecurity.csrf(c -> c.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/public/**", "/public/**", "/error", "/test").permitAll()
                        .requestMatchers("/admin/**").hasRole("TEACHER")
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}
