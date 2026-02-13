package com.rashoj.StudnetManagementSystemAdmin.client;

import com.rashoj.StudnetManagementSystemAdmin.dto.request.TeacherManagementReqDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "STUDENTMANAGEMENTSYSTEMTEACHER")
public interface TeacherDetail {
    @PostMapping("/api/public/save")
 String save(@RequestBody TeacherManagementReqDto teacherSaveReqDto);
}
