package ru.overthantutor.javaSpringWebSemi3Hw.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.overthantutor.javaSpringWebSemi3Hw.domain.User;

/**
 * Spring notification service
 */
@AllArgsConstructor
@Getter
@Service
public class RegistrationService {
    private DataProcessingService dataProcessingService;
    private UserService userService;
    private final NotificationService notificationService;

    /**
     * Processing registration
     * @param name  user name
     * @param age   user age
     * @param email user email
     * @return user or null if registration is not successful
     */
    public User processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        if (dataProcessingService.saveUser(user) != null) {
            notificationService.notifyUser(user);
        } else {
            notificationService.sendNotification("User hasn't been created");
            return null;
        }
        return user;
    }
}
