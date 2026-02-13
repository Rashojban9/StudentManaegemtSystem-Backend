package com.rashoj.StudnetManagementSystemAdmin.service;

import com.rashoj.StudnetManagementSystemAdmin.dto.request.AdminLoginReqDto;
import com.rashoj.StudnetManagementSystemAdmin.dto.response.AdminLoginResDto;
import com.rashoj.StudnetManagementSystemAdmin.jwtConfig.JwtUtils;
import com.rashoj.StudnetManagementSystemAdmin.model.Admin;
import com.rashoj.StudnetManagementSystemAdmin.repo.AdminRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepo repo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AdminLoginResDto login(AdminLoginReqDto adminLoginReqDto) {
       final Admin admin= repo.findByUsername(adminLoginReqDto.getUsername()).orElseThrow(()->new RuntimeException("Admin not found with Username:  "+adminLoginReqDto.getUsername()));

       if(!passwordEncoder.matches(adminLoginReqDto.getPassword(),admin.getPassword())){
           throw new RuntimeException("Password Didnot match");
       }
       return AdminLoginResDto.builder().token(jwtUtils.generatedToken(adminLoginReqDto.getUsername())).build();
    }
}
