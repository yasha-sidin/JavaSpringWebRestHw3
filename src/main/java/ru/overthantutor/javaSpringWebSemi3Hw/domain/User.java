package ru.overthantutor.javaSpringWebSemi3Hw.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity class which provide User substance
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    /**
     * User id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * User name
     */
    @Column(name = "name")
    private String name;
    /**
     * User age
     */
    @Column(name = "age")
    private int age;
    /**
     * User email
     */
    @Column(name = "email")
    private String email;
}
