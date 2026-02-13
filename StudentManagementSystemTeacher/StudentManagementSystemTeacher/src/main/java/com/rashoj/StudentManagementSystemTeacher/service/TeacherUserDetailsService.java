package com.rashoj.StudentManagementSystemTeacher.service;

import com.rashoj.StudentManagementSystemTeacher.model.Teacher;
import com.rashoj.StudentManagementSystemTeacher.repo.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class TeacherUserDetailsService implements UserDetailsService {
    private final TeacherRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher teacher = repo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return User.withUsername(teacher.getEmail())
                .password(teacher.getPassword())
                .authorities("TEACHER")
                .build();
    }

}
