package com.rashoj.StudnetManagementSystemAdmin.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class TeacherManagementResDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String bio;

    private LocalDate dob;
}
