package org.example.spingauth.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping
    public Set<String> login(@RequestBody UserParam user) {
        return userService.login(user);
    }
}
