package org.example.spingauth.authorization.controller;

import org.example.spingauth.authorization.model.Resource;
import org.example.spingauth.authorization.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @GetMapping("/resource/list")
    public List<Resource> getList() {
        return resourceService.list();
    }
}
