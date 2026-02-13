package com.rashoj.StudentManagementSystemTeacher.dto.response;

import lombok.Builder;

@Builder
public record TeacherSigninResDto(
        String firstName,
        String lastName,
        String email,
        String token
) {
}