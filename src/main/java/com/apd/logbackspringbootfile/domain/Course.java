package com.apd.logbackspringbootfile.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Represents a course entity in the system.
 * <p>
 * This entity is mapped to the database table {@code course_tb}.
 * Each course has a unique ID, code, name, credit hours, description,
 * a flag indicating if it is enabled, and the creator's ID.
 * </p>
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {

    /**
     * The unique identifier of the course.
     * Generated automatically using UUID strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID courseId;

    /**
     * The unique code representing the course.
     */
    private String courseCode;

    /**
     * The name of the course.
     */
    private String courseName;

    /**
     * The number of credit hours associated with the course.
     */
    private String creditHours;

    /**
     * A brief description of the course content.
     */
    private String description;

    /**
     * A boolean flag indicating whether the course is isEnabled or not.
     * Default is {@code true}.
     */
    private boolean isEnabled = true;

    /**
     * The price of the course.
     */
    private String price;

}
