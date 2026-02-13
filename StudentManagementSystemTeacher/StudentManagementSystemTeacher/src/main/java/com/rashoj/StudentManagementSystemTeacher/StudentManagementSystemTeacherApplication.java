package com.rashoj.StudentManagementSystemTeacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
//@EnableJpaAuditing
@EnableMethodSecurity
public class StudentManagementSystemTeacherApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemTeacherApplication.class, args);
    }

}
