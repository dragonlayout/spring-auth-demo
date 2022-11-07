package org.example.spingauth.authorization.repository;

import org.example.spingauth.authorization.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    void deleteByUserId(Long userId);
}
