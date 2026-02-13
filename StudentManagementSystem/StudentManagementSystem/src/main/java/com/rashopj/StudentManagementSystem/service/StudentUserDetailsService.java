package com.rashopj.StudentManagementSystem.service;

import com.rashopj.StudentManagementSystem.model.Student;
import com.rashopj.StudentManagementSystem.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class StudentUserDetailsService implements UserDetailsService {
    private final StudentRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = repo.findByEmail(username).orElseThrow(() -> new RuntimeException("Student Not found"));
        if (student == null) {
            throw new UsernameNotFoundException("Student not found: " + username);
        }
        return User.withUsername(student.getEmail())
                .password(student.getPassword())
                .authorities("STUDENT")
                .build();
    }
}
