package org.example.spingauth.authorization.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.example.spingauth.authorization.model.QUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    JPAQueryFactory queryFactory;

    public List<Long> getRoleIdByUserId(Long userId) {
        QUserRole qUserRole = QUserRole.userRole;
        return queryFactory
                .select(qUserRole.roleId)
                .from(qUserRole)
                .where(qUserRole.userId.eq(userId)).fetch();
    }
}
