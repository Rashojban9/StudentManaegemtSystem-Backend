package com.rashoj.StudentManagementSystemTeacher.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@EntityListeners(AuditingEntityListener.class)

public class Teacher {
    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String bio;
    @CreationTimestamp
    private LocalDate joinDate;
    private LocalDate dob;


}
