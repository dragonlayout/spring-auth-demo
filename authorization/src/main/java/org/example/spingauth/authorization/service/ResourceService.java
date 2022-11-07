package org.example.spingauth.authorization.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.example.spingauth.authorization.UserMenuParam;
import org.example.spingauth.authorization.model.Resource;
import org.example.spingauth.authorization.model.UserResource;
import org.example.spingauth.authorization.repository.ResourceRepository;
import org.example.spingauth.authorization.repository.UserResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceService {

    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    UserResourceRepository userResourceRepository;

    @Autowired
    JPAQueryFactory queryFactory;

    @Transactional
    public void updateMenu(UserMenuParam param) {
        userResourceRepository.deleteByUserId(param.getId());
        if (CollectionUtils.isEmpty(param.getMenus())) {
            return;
        }
        userResourceRepository.saveAll(param.getMenus().stream().map(resourceId -> {
            UserResource userResource = new UserResource();
            userResource.setUserId(param.getId());
            userResource.setResourceId(resourceId);
            return userResource;
        }).collect(Collectors.toSet()));
    }

    public List<Resource> list() {
        return resourceRepository.findAll();
    }
}
