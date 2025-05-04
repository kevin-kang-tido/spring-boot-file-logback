package com.apd.logbackspringbootfile.feature;

import com.apd.logbackspringbootfile.domain.Course;
import com.apd.logbackspringbootfile.feature.dto.CourseRequest;
import com.apd.logbackspringbootfile.feature.dto.CourseResponse;
import com.apd.logbackspringbootfile.utils.CourseSpecification;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;


    @Override
    public Course createCourse(CourseRequest courseRequest) {

        Course newCourse = new Course();

        newCourse.setCourseCode(courseRequest.getCourseCode());
        newCourse.setCourseName(courseRequest.getCourseName());
        newCourse.setCreditHours(courseRequest.getCreditHours());
        newCourse.setDescription(courseRequest.getDescription());


        return courseRepository.save(newCourse);
    }

    @Override
    public Page<Course> getAllEnableCourse(Integer page, Integer size) {
        // TODO: make it as list page
        PageRequest pageRequest = PageRequest.of(page, size);
        // TODO: query only the courses isEnable TRUE
        Page<Course> courses = courseRepository.findAllByEnabledTrue(pageRequest);

        return courses;
    }

    @Override
    public Page<Course> getAllCourses(Integer page, Integer size) {

        PageRequest pageRequest = PageRequest.of(page, size);

        Page<Course> courses = courseRepository.findAll(pageRequest);

        return courses;
    }

    @Override
    public CourseResponse getCourseById(UUID courseId) {

//
        // log
        log.info("Fetch data from the database!");
        System.out.println("Fetch data form the database!");

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course" + getCourseById(courseId) + " not found"
                ));

        return new CourseResponse(
                course.getCourseId(),
                course.getCourseCode(),
                course.getCourseName(),
                course.getCreditHours(),
                course.getDescription()
        );
    }

    @Override
    public Course updateCourseById(UUID courseId, CourseRequest courseRequest) {
        Course existingCourse = courseRepository.findById(courseId).orElseThrow();
        existingCourse.setCourseCode(courseRequest.getCourseCode());
        existingCourse.setCourseName(courseRequest.getCourseName());
        existingCourse.setCreditHours(courseRequest.getCreditHours());
        existingCourse.setDescription(courseRequest.getDescription());

//        clearAllCoursesCache(); // TODO: clear all cache on the redis when course update

        return courseRepository.save(existingCourse);
    }


    @Override
    public void deleteCourseById(UUID courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    @Transactional
    public Course enableCourse(UUID courseId) {
        log.info("Enabling course ID: " , courseId);
        Course course = courseRepository.findById(courseId).orElseThrow();
        course.setEnabled(true);
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course disableCourse(UUID courseId) {
        log.info("Disabling course ID: " , courseId);
        Course course = courseRepository.findById(courseId).orElseThrow();
        course.setEnabled(false);
        return courseRepository.save(course);
    }

    @Override
    public Page<Course> searchCourses(String name, String creditHours, Boolean isEnabled, Integer page, Integer size) {

        Specification<Course> specification  = Specification
                .where(CourseSpecification.isEnabled(isEnabled))
                .and(CourseSpecification.hasName(name))
                .and(CourseSpecification.hasCreditHours(creditHours));

        return courseRepository.findAll(specification,PageRequest.of(page, size));
    }
}
