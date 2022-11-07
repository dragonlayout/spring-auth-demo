package org.example.spingauth.authorization.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.example.spingauth.authorization.UserMenuParam;
import org.example.spingauth.authorization.model.Resource;
import org.example.spingauth.authorization.model.Role;
import org.example.spingauth.authorization.model.RoleResource;
import org.example.spingauth.authorization.repository.ResourceRepository;
import org.example.spingauth.authorization.repository.RoleRepository;
import org.example.spingauth.authorization.repository.RoleResourceRepository;
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
    RoleResourceRepository roleResourceRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JPAQueryFactory queryFactory;

    @Transactional
    public void updateMenu(UserMenuParam param) {
        roleResourceRepository.deleteByRoleId(param.getId());
        if (CollectionUtils.isEmpty(param.getMenus())) {
            return;
        }
        roleResourceRepository.saveAll(param.getMenus().stream().map(resourceId -> {
            RoleResource roleResource = new RoleResource();
            roleResource.setRoleId(param.getId());
            roleResource.setResourceId(resourceId);
            return roleResource;
        }).collect(Collectors.toSet()));
    }

    public List<Resource> resourceList() {
        return resourceRepository.findAll();
    }

    public List<Role> roleList() {
        return roleRepository.findAll();
    }
}
