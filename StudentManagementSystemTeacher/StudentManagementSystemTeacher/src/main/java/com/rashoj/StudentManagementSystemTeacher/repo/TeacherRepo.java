package com.rashoj.StudentManagementSystemTeacher.repo;

import com.rashoj.StudentManagementSystemTeacher.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TeacherRepo extends JpaRepository<Teacher, UUID> {

    Optional<Teacher> findByEmail(String email);
}
