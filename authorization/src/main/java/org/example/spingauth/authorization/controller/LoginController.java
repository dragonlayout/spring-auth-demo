package org.example.spingauth.authorization.controller;

import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.example.spingauth.authorization.UserMenuParam;
import org.example.spingauth.authorization.UserParam;
import org.example.spingauth.authorization.service.ResourceService;
import org.example.spingauth.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    ResourceService resourceService;

    @Autowired
    JPAQueryFactory queryFactory;

    @PostMapping("/login")
    public List<Long> login(@RequestBody UserParam user) {
        return userService.login(user);
    }

    @PutMapping("/menu")
    public String updateMenus(@RequestBody UserMenuParam param) {
        resourceService.updateMenu(param);
        return "操作成功";
    }
}
