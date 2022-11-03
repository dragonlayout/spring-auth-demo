package org.example.spingauth.authorization;

import org.example.spingauth.authorization.repository.ResourceRepository;
import org.example.spingauth.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ResourceRepository resourceRepository;

    public Set<String> login(UserParam userParam) {
        User user = userRepository.findUserByUsernameAndPassword(userParam.getUsername(),
                userParam.getPassword());
        if (user == null) {
            throw new ApiException("账号或密码错误");
        }
        return resourceRepository.findResourcesByUserId(user.getId()).stream().map(resource -> {
            resource.getPath();
        });
        return null;
    }
}
