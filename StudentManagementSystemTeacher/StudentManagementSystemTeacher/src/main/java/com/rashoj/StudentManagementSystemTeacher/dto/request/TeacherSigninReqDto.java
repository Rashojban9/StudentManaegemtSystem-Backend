package com.rashoj.StudentManagementSystemTeacher.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeacherSigninReqDto {
    private String email;
    private String password;
}
