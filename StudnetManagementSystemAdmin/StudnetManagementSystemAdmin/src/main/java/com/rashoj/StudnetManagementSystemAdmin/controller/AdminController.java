package com.rashoj.StudnetManagementSystemAdmin.controller;

import com.rashoj.StudnetManagementSystemAdmin.dto.request.AdminLoginReqDto;
import com.rashoj.StudnetManagementSystemAdmin.route.AdminRoute;
import com.rashoj.StudnetManagementSystemAdmin.service.AdminService;
import com.rashoj.StudnetManagementSystemAdmin.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService service;
   @PostMapping(AdminRoute.LOGIN)
    public ResponseEntity<?>login(@RequestBody AdminLoginReqDto adminLoginReqDto){
       return Response.sucess("Login sucessfully",service.login(adminLoginReqDto));
   }
}
