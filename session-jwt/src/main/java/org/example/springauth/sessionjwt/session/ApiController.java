package org.example.springauth.sessionjwt.session;

import lombok.extern.slf4j.Slf4j;
import org.example.springauth.sessionjwt.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class ApiController {

    @GetMapping("/api")
    public String api() {
        return "成功返回数据";
    }
}
