package org.example.springauth.sessionjwt.jwt;

import org.example.springauth.sessionjwt.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            return JavaJwtUtils.generateToken("admin");
        }
        return "账号或密码错误";
    }

    @GetMapping("/api")
    public String api(HttpServletRequest request) {
        return "api成功返回数据";
    }
}
