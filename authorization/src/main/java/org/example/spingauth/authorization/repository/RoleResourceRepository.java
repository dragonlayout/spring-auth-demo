package org.example.spingauth.authorization.repository;

import org.example.spingauth.authorization.model.RoleResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleResourceRepository extends JpaRepository<RoleResource, Long> {
    void deleteByRoleId(Long roleId);
}
