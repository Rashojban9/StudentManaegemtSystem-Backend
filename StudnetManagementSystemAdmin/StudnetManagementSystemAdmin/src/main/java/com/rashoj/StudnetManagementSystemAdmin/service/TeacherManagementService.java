package com.rashoj.StudnetManagementSystemAdmin.service;

import com.rashoj.StudnetManagementSystemAdmin.client.TeacherDetail;
import com.rashoj.StudnetManagementSystemAdmin.dto.request.TeacherManagementReqDto;
import com.rashoj.StudnetManagementSystemAdmin.dto.response.TeacherManagementResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherManagementService {
    private final TeacherDetail teacherDetail;

    public String save(TeacherManagementReqDto teacherManagementReqDto) {
        return teacherDetail.save(teacherManagementReqDto);
    }
}
