package ru.overthantutor.javaSpringWebSemi3Hw.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.overthantutor.javaSpringWebSemi3Hw.domain.User;
import ru.overthantutor.javaSpringWebSemi3Hw.service.DataProcessingService;

import java.util.List;

/**
 * Spring controller which control tasks requests
 */
@AllArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private DataProcessingService dataProcessingService;

    /**
     * Getting all tasks
     * @return list of all tasks names
     */
    @GetMapping
    public List<String> getAllTasks() {
        return List.of("sort", "filter", "calc");
    }

    /**
     * Getting sorted by age list of users
     * @return sorted by age list of users
     */
    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return dataProcessingService.sortUsersByAge();
    }

    /**
     * Filtering by age users
     * @param age min age
     * @return    list of filtering by age users
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return dataProcessingService.filterUsersByAge(age);
    }

    /**
     * Calculating average age of users
     * @return average age of users
     */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        return dataProcessingService.calculateAverageAge();
    }
}
