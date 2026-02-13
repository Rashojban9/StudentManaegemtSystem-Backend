package com.rashoj.StudentManagementSystemTeacher.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherSaveDto {
    private String firstName;
    private String lastName;
    private String email;

    private String bio;
    private LocalDate joinDate;
    private LocalDate dob;
}
