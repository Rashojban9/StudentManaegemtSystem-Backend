package com.rashopj.StudentManagementSystem.controller;

import com.rashopj.StudentManagementSystem.dto.request.StudentLoginReqDto;
import com.rashopj.StudentManagementSystem.dto.request.StudentSignupReqDto;
import com.rashopj.StudentManagementSystem.dto.request.StudentUpdatePasswordReqDto;
import com.rashopj.StudentManagementSystem.route.StudentRoute;
import com.rashopj.StudentManagementSystem.service.StudentService;
import com.rashopj.StudentManagementSystem.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @PostMapping(StudentRoute.SIGNUP)
    public ResponseEntity<?> signup(@RequestBody StudentSignupReqDto studentSignupReqDto) {
        return Response.created("Student Successfully created", service.signup(studentSignupReqDto));

    }

    @PostMapping(StudentRoute.LOGIN)
    public ResponseEntity<?> login(@RequestBody StudentLoginReqDto studentLoginReqDto) {
        return Response.sucess("login Sucessfully", service.login(studentLoginReqDto.getEmail(), studentLoginReqDto.getPassword()));

    }
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping(StudentRoute.PROFILE)
    public ResponseEntity<?> profile(Authentication authentication) {
        String email = authentication.getName();
        return Response.sucess("profile loaded", service.profile(email));
    }
    @PreAuthorize("hasRole('STUDENT')")
    @PutMapping(StudentRoute.UPDATE_PASSWORD)
    public ResponseEntity<?> updatePassword(@RequestBody StudentUpdatePasswordReqDto studentUpdatePasswordReqDto, Authentication authentication) {
        return Response.sucess("Password Updated Sucessfully", service.updatePassword(studentUpdatePasswordReqDto, authentication));
    }

}
