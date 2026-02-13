package com.rashopj.StudentManagementSystem.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class StudentSignupReqDto {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String password;
}
