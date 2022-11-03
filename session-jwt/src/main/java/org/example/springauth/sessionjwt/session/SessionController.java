package org.example.springauth.sessionjwt.session;

import lombok.extern.slf4j.Slf4j;
import org.example.springauth.sessionjwt.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class SessionController {

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession httpSession) {
        String sessionId = httpSession.getId();
        log.info("sessionId: {}", sessionId);
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            httpSession.setAttribute("user", user);
            return "登录成功";
        }
        return "账号或密码错误";
    }

    @PostMapping("/logout")
    public String logout(HttpSession httpSession) {
        String sessionId = httpSession.getId();
        log.info("sessionId: {}", sessionId);
        httpSession.removeAttribute("user");
        return "退出成功";
    }
}
