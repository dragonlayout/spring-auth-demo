package org.example.spingauth.authorization.repository;

import org.example.spingauth.authorization.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    Set<Resource> findResourcesByUserId(Long userId);

    void deleteByUserId(Long userId);

}
