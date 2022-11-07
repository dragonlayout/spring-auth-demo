package org.example.spingauth.authorization.repository;

import org.example.spingauth.authorization.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
