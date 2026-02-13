package com.rashoj.StudnetManagementSystemAdmin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
@AttributeOverrides({
        @AttributeOverride(name = "username",column = @Column(name = "user_name",nullable = false)),
        @AttributeOverride(name = "password",column = @Column(name = "password",nullable = false)),
        @AttributeOverride(name="firstname",column = @Column(name = "first_name",nullable = false))
})
public class Admin {
    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
