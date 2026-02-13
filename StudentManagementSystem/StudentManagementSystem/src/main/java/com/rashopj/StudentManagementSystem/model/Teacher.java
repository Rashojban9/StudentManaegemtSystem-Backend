package com.rashopj.StudentManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue
    private UUID id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String department;
    private String bio;
    private boolean isActive;
    private String phoneNumber;
}
