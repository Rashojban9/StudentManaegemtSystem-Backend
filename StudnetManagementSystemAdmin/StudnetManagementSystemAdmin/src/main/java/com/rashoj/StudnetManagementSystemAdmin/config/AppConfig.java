package com.rashoj.StudnetManagementSystemAdmin.config;

import com.rashoj.StudnetManagementSystemAdmin.jwtConfig.JwtsFilterChain;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final JwtsFilterChain jwtsFilterChain;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        return httpSecurity.csrf(csrf->csrf.disable())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth->auth.requestMatchers("/api/public/**","/public/**","/error","/").permitAll()
                        .requestMatchers("/api/public/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .addFilterBefore(jwtsFilterChain, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
