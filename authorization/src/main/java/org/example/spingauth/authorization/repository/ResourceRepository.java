package org.example.spingauth.authorization.repository;

import org.example.spingauth.authorization.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
