package com.rashoj.StudentManagementSystemTeacher.controller;

import com.rashoj.StudentManagementSystemTeacher.dto.request.TeacherSaveReqDto;
import com.rashoj.StudentManagementSystemTeacher.dto.request.TeacherSigninReqDto;
import com.rashoj.StudentManagementSystemTeacher.route.TeacherRoute;
import com.rashoj.StudentManagementSystemTeacher.service.TeacherService;
import com.rashoj.StudentManagementSystemTeacher.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService service;

    @PostMapping(TeacherRoute.SAVE)
    public String save(@RequestBody TeacherSaveReqDto teacherSaveReqDto) {
        return service.save(teacherSaveReqDto);


    }

    @PostMapping(TeacherRoute.SIGN_IN)
    public ResponseEntity<?> login(@RequestBody TeacherSigninReqDto teacherSigninReqDto) {
        return Response.sucess("sucessfully signin", service.signin(teacherSigninReqDto));
    }

}
