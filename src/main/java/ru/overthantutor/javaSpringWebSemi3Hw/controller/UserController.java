package ru.overthantutor.javaSpringWebSemi3Hw.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.overthantutor.javaSpringWebSemi3Hw.domain.User;
import ru.overthantutor.javaSpringWebSemi3Hw.service.RegistrationService;

import java.util.List;

/**
 * Spring controller which control requests to control users
 */
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private RegistrationService registrationService;

    /**
     * Getting all users
     * @return list of all users
     */
    @GetMapping
    public List<User> getUsers() {
        return registrationService.getDataProcessingService().readAll();
    }

    /**
     * Creating user using data from POST body
     * @param user user which was made from request POST body
     * @return     results of registration
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        User userReg = registrationService.processRegistration(user.getName(), user.getAge(), user.getEmail());
        if (userReg == null) return "User NOT added from body!";
        return "User added from body!";
    }

    /**
     * Creating user using info from params
     * @param name  user name
     * @param age   user age
     * @param email user email
     * @return      results of registration
     */
    @GetMapping("/param")
    public String userAddFromParam(@RequestParam("name") String name,
                                   @RequestParam("age") int age,
                                   @RequestParam("email") String email) {
        User user = registrationService.processRegistration(name, age, email);
        if (user == null) return "User NOT added from param!";
        return "User added from param!";
    }
}
