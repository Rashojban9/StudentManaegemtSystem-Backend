package com.rashopj.StudentManagementSystem.dto.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentUpdatePasswordReqDto {
    private String oldPassword;
    private String newPassword;
}
