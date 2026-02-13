package com.rashopj.StudentManagementSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "student", uniqueConstraints = @UniqueConstraint(name = "emailid_unique", columnNames = "email"))
@Getter
@Setter
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
        @AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
})

public class Student {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String Password;
    @Column(nullable = false)
    private LocalDate dob;

}
