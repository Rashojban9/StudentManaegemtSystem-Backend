package com.rashoj.StudentManagementSystemTeacher.service;

import com.rashoj.StudentManagementSystemTeacher.dto.request.TeacherSaveReqDto;
import com.rashoj.StudentManagementSystemTeacher.dto.request.TeacherSigninReqDto;
import com.rashoj.StudentManagementSystemTeacher.dto.response.TeacherSigninResDto;
import com.rashoj.StudentManagementSystemTeacher.jwtConfig.JwtUtil;
import com.rashoj.StudentManagementSystemTeacher.mapper.TeacherMapper;
import com.rashoj.StudentManagementSystemTeacher.model.Teacher;
import com.rashoj.StudentManagementSystemTeacher.repo.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class TeacherService {
    private final TeacherRepo repo;
    private final TeacherMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String save(TeacherSaveReqDto teacherSaveReqDto) {
        Teacher teacher = mapper.toEntity(teacherSaveReqDto);
        teacher.setPassword(passwordEncoder.encode(teacherSaveReqDto.getPassword()));
        mapper.toRes(repo.save(teacher));
        return "";
    }

    public TeacherSigninResDto signin(TeacherSigninReqDto teacherSigninReqDto) {
        Teacher teacher = repo.findByEmail(teacherSigninReqDto.getEmail()).orElseThrow(() -> new UsernameNotFoundException("user does not exist"));
        if (!passwordEncoder.matches(teacherSigninReqDto.getPassword(), teacher.getPassword())) {
            throw new RuntimeException("password didinot match");


        }
        return TeacherSigninResDto.builder().token(jwtUtil.generateToken(teacherSigninReqDto.getEmail())).firstName(teacher.getFirstName()).lastName(teacher.getLastName()).email(teacherSigninReqDto.getEmail()).build();
    }
}
