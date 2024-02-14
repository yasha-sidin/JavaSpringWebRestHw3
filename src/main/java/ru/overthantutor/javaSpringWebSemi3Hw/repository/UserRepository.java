package ru.overthantutor.javaSpringWebSemi3Hw.repository;

import org.springframework.stereotype.Repository;
import ru.overthantutor.javaSpringWebSemi3Hw.domain.User;

/**
 * Spring repository which extends DatabaseRepository and keeps users
 */
@Repository
public class UserRepository extends DatabaseRepository<User> {
}
