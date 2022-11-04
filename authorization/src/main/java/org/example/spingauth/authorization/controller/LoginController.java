package org.example.spingauth.authorization.controller;

import org.example.spingauth.authorization.UserParam;
import org.example.spingauth.authorization.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    ResourceService resourceService;

    @PostMapping("/login")
    public Set<String> login(@RequestBody UserParam user) {
        return userService.login(user);
    }

    @PutMapping("/menu")
    public String updateMenus(@RequestBody UserMenuParam param) {
        resourceService.updateMenu(param);
        return "操作成功";
    }
}