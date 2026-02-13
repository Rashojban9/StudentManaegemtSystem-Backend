package com.rashopj.StudentManagementSystem.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class StudentLoginReqDto {
    private String email;
    private String password;
}
