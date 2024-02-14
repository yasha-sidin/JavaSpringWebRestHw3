package ru.overthantutor.javaSpringWebSemi3Hw.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.overthantutor.javaSpringWebSemi3Hw.domain.User;

/**
 * Spring notification service
 */
@AllArgsConstructor
@Service
public class NotificationService {

    /**
     * Notification about creating user
     * @param user
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user);
    }

    /**
     * Some notification
     * @param data notification body
     */
    public void sendNotification(String data) {
        System.out.println(data);
    }
}
