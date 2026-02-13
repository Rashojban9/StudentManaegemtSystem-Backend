package com.rashoj.StudnetManagementSystemAdmin.repo;

import com.rashoj.StudnetManagementSystemAdmin.model.Admin;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdminRepo extends JpaRepository<Admin, UUID> {
    Optional<Admin> findByUsername(String username);
}
