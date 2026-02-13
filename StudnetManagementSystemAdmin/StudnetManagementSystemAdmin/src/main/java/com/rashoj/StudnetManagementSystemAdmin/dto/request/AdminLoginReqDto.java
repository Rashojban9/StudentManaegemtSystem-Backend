package com.rashoj.StudnetManagementSystemAdmin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminLoginReqDto {
    private String username;
    private String password;
}
