package org.example.spingauth.authorization.repository;

import org.example.spingauth.authorization.model.UserResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface UserResourceRepository extends JpaRepository<UserResource, Long> {

    /**
     * 根据 user_id 删除该用户的所有权限
     */
    void deleteByUserId(Long userId);

    /**
     * 根据 user_id 获取权限id
     */
    Set<UserIdOnly> findByUserId(Long userId);
    interface UserIdOnly {
        String getUserId();
    }
}
