package ru.overthantutor.javaSpringWebSemi3Hw.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.overthantutor.javaSpringWebSemi3Hw.domain.User;
import ru.overthantutor.javaSpringWebSemi3Hw.repository.UserRepository;


import java.util.List;
import java.util.Optional;

/**
 * Spring service class which is creating User objects
 */
@AllArgsConstructor
@Service
public class UserService {

    /**
     * Creating User object
     * @param name  user name
     * @param age   user age
     * @param email user email
     * @return      new User object
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return user;
    }
}
