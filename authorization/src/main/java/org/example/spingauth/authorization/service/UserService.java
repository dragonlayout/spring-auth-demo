package org.example.spingauth.authorization.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.example.spingauth.authorization.ApiException;
import org.example.spingauth.authorization.UserParam;
import org.example.spingauth.authorization.model.*;
import org.example.spingauth.authorization.repository.ResourceRepository;
import org.example.spingauth.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    JPAQueryFactory queryFactory;

    public List<String> login(UserParam userParam) {
        User user = userRepository.findUserByUsernameAndPassword(userParam.getUsername(),
                userParam.getPassword());
        if (user == null) {
            throw new ApiException("账号或密码错误");
        }
        QResource qResource = QResource.resource;
        QUser qUser = QUser.user;
        QUserResource qUserResource = QUserResource.userResource;

        return queryFactory.select(qResource.path)
                .from(qResource)
                .leftJoin(qUserResource)
                .on(qResource.id.eq(qUserResource.resourceId))
                .where(qUserResource.userId.eq(user.getId())).fetch();
    }
}
