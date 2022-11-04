package org.example.spingauth.authorization.controller;

import org.example.spingauth.authorization.Resource;
import org.example.spingauth.authorization.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
public class ResourceService {

    @Autowired
    ResourceRepository resourceRepository;

    @Transactional
    public void updateMenu(UserMenuParam param) {
        resourceRepository.deleteByUserId(param.getId());
        if (CollectionUtils.isEmpty(param.getMenus())) {
            return;
        }
        resourceRepository.saveAll(param.getMenus().stream().map(s -> {
            Resource r = new Resource();
            r.setUserId(param.getId());
            r.setPath(s);
            return r;
        }).collect(Collectors.toSet()));
    }
}
