package com.rashoj.StudnetManagementSystemAdmin.controller;

import com.rashoj.StudnetManagementSystemAdmin.dto.request.TeacherManagementReqDto;
import com.rashoj.StudnetManagementSystemAdmin.dto.response.TeacherManagementResDto;
import com.rashoj.StudnetManagementSystemAdmin.route.TeacherManagementRoute;
import com.rashoj.StudnetManagementSystemAdmin.service.TeacherManagementService;
import com.rashoj.StudnetManagementSystemAdmin.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeacherManagementContoller {
    private final TeacherManagementService teacherManagementService;
    @PostMapping(TeacherManagementRoute.TEACHER_ENTRY)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> teacherEntry(@RequestBody TeacherManagementReqDto teacherManagementReqDto){
       return Response.sucess("Teacher Save Sucessfully",teacherManagementService.save(teacherManagementReqDto));

    }
}
