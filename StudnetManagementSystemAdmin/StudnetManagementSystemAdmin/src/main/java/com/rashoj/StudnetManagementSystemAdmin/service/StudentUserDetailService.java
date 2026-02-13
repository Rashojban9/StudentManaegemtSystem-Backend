package com.rashoj.StudnetManagementSystemAdmin.service;

import com.rashoj.StudnetManagementSystemAdmin.model.Admin;
import com.rashoj.StudnetManagementSystemAdmin.repo.AdminRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class StudentUserDetailService implements UserDetailsService {
   private final AdminRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Admin admin=repo.findByUsername(username).orElseThrow(()->new RuntimeException("username not found"));
      if(admin==null){
          throw new UsernameNotFoundException("Username not found");

      }
      return User.withUsername(admin.getUsername()).password(admin.getPassword()).authorities("ADMIN").build();


    }
}
