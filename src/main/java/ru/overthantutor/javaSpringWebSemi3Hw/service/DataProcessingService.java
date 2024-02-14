package ru.overthantutor.javaSpringWebSemi3Hw.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.overthantutor.javaSpringWebSemi3Hw.domain.User;
import ru.overthantutor.javaSpringWebSemi3Hw.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Spring data processing service
 */
@AllArgsConstructor
@Getter
@Service
public class DataProcessingService {
    private UserRepository userRepository;

    /**
     * Reading all data from database repository
     * @return List of user if they exist or null if it is not true
     */
    public List<User> readAll() {
        Optional<List<User>> optional = userRepository.readAllData(User.class);
        return optional.orElse(List.of());
    }

    /**
     * Saving user into repository
     * @param user saving user
     * @return     saving user if operation is successful or null if it is not true
     */
    public User saveUser(User user) {
        if (userRepository.insertData(user)) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * Deleting user by id
     * @param id user id
     * @return   deleted user or null if it is not exist
     */
    public User deleteById(long id) {
        Optional<User> optional = userRepository.readData(id, User.class);
        if (optional.isPresent()) {
            userRepository.dropData(optional.get());
            return optional.get();
        } else {
            return null;
        }
    }

    /**
     * Updating user
     * @param user user with updated data
     * @return     updated user or null if it is not exists
     */
    public User updateUser(User user) {
        Optional<User> optional = userRepository.readData(user.getId(), User.class);
        if (optional.isPresent()) {
            userRepository.updateData(user);
            return user;
        } else {
            return null;
        }
    }

    /**
     * Getting user by id
     * @param id user id
     * @return   user or null if it is not exist
     */
    public User getUserById(long id) {
        return userRepository.readData(id, User.class).orElse(null);
    }

    /**
     * Sorting users by age in main order
     * @return sorted by age list of users
     */
    public List<User> sortUsersByAge() {
        return readAll().stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Filtering users by age
     * @param age min age
     * @return    filtered by age list of users
     */
    public List<User> filterUsersByAge(int age) {
        return readAll().stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Calculating average age of users
     * @return result of average age of users
     */
    public double calculateAverageAge() {
        return readAll().stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
}
