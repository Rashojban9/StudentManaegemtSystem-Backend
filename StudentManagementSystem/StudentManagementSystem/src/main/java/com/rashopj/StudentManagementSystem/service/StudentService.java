package com.rashopj.StudentManagementSystem.service;

import com.rashopj.StudentManagementSystem.dto.request.StudentSignupReqDto;
import com.rashopj.StudentManagementSystem.dto.request.StudentUpdatePasswordReqDto;
import com.rashopj.StudentManagementSystem.dto.response.StudentLoginResDto;
import com.rashopj.StudentManagementSystem.dto.response.StudentProfileResDto;
import com.rashopj.StudentManagementSystem.dto.response.StudentSignupResDto;
import com.rashopj.StudentManagementSystem.jwtConfig.JwtUtils;
import com.rashopj.StudentManagementSystem.mapper.StudentMapper;
import com.rashopj.StudentManagementSystem.model.Student;
import com.rashopj.StudentManagementSystem.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentMapper mapper;
    private final StudentRepo repo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public StudentSignupResDto signup(StudentSignupReqDto studentSignupReqDto) {
        if (repo.findByEmail(studentSignupReqDto.getEmail()).isPresent()) {
            throw new RuntimeException("Student already exist");
        }

        Student student = mapper.tomodel(studentSignupReqDto);
        student.setPassword(passwordEncoder.encode(studentSignupReqDto.getPassword()));
        return mapper.toResDto(repo.save(student));
    }

    public StudentLoginResDto login(String email, String password) {

        final Student student = repo.findByEmail(email).orElseThrow(() -> new RuntimeException("user does nopt exist"));

        if (!passwordEncoder.matches(password, student.getPassword())) {
            throw new RuntimeException("password didnot match");
        }

        return StudentLoginResDto.builder().token(jwtUtils.generateToken(email)).build();

    }

    public StudentProfileResDto profile(String email) {
        Student student = repo.findByEmail(email).orElseThrow(() -> new RuntimeException("user doesnot exist"));
        return StudentProfileResDto.builder().firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .dob(student.getDob())
                .build();
    }

    public String updatePassword(StudentUpdatePasswordReqDto studentUpdatePasswordReqDto, Authentication authentication) {
        final Student student = repo.findByEmail(authentication.getName()).orElseThrow(() -> new RuntimeException("Student not found "));
        if (!passwordEncoder.matches(studentUpdatePasswordReqDto.getOldPassword(), student.getPassword())) {
            throw new RuntimeException("Old password didn't match");
        }
        student.setPassword(passwordEncoder.encode(studentUpdatePasswordReqDto.getNewPassword()));
        repo.save(student);

        return "";

    }
}
