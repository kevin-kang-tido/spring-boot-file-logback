package com.apd.logbackspringbootfile.feature;



import com.apd.logbackspringbootfile.domain.Course;
import com.apd.logbackspringbootfile.feature.dto.CourseRequest;
import com.apd.logbackspringbootfile.feature.dto.CourseResponse;
import org.springframework.data.domain.Page;

import java.util.UUID;

/**
 * Service interface for handling all course-related operations.
 * <p>
 * This interface defines the contract for creating, updating, deleting,
 * retrieving, enabling, and disabling courses in the system.
 * </p>
 */
public interface CourseService {

    /**
     * Creates a new course in the system.
     *
     * @param courseRequest The course data sent from the client.
     * @return The created {@link Course} entity.p;['\
     */
    Course createCourse(CourseRequest courseRequest);

    /**
     * Retrieves all courses with pagination.
     *
     * @param page The page number (zero-based).
     * @param size The number of courses per page.
     * @return A page of {@link Course} entities.
     */
    Page<Course> getAllEnableCourse(Integer page, Integer size);

    /**
     * Retrieves all courses with pagination.
     *
     * @param page The page number (zero-based).
     * @param size The number of courses per page.
     * @return A page of {@link Course} entities.
     */
    Page<Course> getAllCourses(Integer page, Integer size);

    /**
     * Retrieves detailed information of a course by its ID.
     *
     * @param courseId The UUID of the course to retrieve.
     * @return A {@link CourseResponse} containing course details and creator info.
     */
    CourseResponse getCourseById(UUID courseId);

    /**
     * Updates an existing course based on the provided ID and request data.
     *
     * @param courseId      The UUID of the course to update.
     * @param courseRequest The updated course data.
     * @return The updated {@link Course} entity.
     */
    Course updateCourseById(UUID courseId, CourseRequest courseRequest);

    /**
     * Deletes a course from the system using its ID.
     *
     * @param courseId The UUID of the course to delete.
     */
    void deleteCourseById(UUID courseId);

    /**
     * Enables a course, setting its `enabled` flag to {@code true}.
     *
     * @param courseId The UUID of the course to enable.
     * @return The updated {@link Course} entity.
     */
    Course enableCourse(UUID courseId);

    /**
     * Disables a course, setting its `enabled` flag to {@code false}.
     *
     * @param courseId The UUID of the course to disable.
     * @return The updated {@link Course} entity.
     */
    Course disableCourse(UUID courseId);


    Page<Course> searchCourses(String name, String creditHours, Boolean isEnabled, Integer page, Integer size);


    Page<Course> searchCoursesWithPrice(String name, String creditHours, Boolean isEnabled, Integer page, Integer size,Integer price);
}
