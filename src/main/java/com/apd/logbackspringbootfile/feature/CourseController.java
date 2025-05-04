package com.apd.logbackspringbootfile.feature;

import com.apd.logbackspringbootfile.domain.Course;
import com.apd.logbackspringbootfile.feature.dto.CourseRequest;
import com.apd.logbackspringbootfile.feature.dto.CourseResponse;
import com.apd.logbackspringbootfile.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @PostMapping("create-new-course")
    public ResponseEntity<ApiResponse<Course>> createResponse(@RequestBody CourseRequest courseRequest) {
        Course course = courseService.createCourse(courseRequest);
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("You have successfully created a new course!")
                .status(HttpStatus.CREATED)
                .payload(course)
                .date(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("get-all-enable-courses")
    public ResponseEntity<?> getAllEnableCourse(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "12") Integer size
    ) {

        return ResponseEntity.accepted().body(
                Map.of(
                        "courses_enable", courseService.getAllEnableCourse(page, size)
                )
        );
    }

    @GetMapping("/get-all-course")
    public ResponseEntity<?> getAllCourses(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "12") Integer size
    ) {
        return ResponseEntity.accepted().body(
                Map.of(
                        "courses", courseService.getAllCourses(page, size)

                )
        );
    }


    @GetMapping("/{courseId}")
    public ResponseEntity<ApiResponse<CourseResponse>> getCourseById(@PathVariable UUID courseId) {
        CourseResponse courseResponse = courseService.getCourseById(courseId);

        ApiResponse<CourseResponse> response = ApiResponse.<CourseResponse>builder()
                .message("Successfully get course by id")
                .status(HttpStatus.OK)
                .payload(courseResponse)
                .date(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<ApiResponse<Course>> updateCourseById(@PathVariable UUID courseId, @RequestBody CourseRequest courseRequest) {

        Course course = courseService.updateCourseById(courseId, courseRequest);

        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("You have successfully updated the course!")
                .status(HttpStatus.OK)
                .payload(course)
                .date(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<ApiResponse<Void>> deleteCourseById(@PathVariable UUID courseId) {

        courseService.deleteCourseById(courseId);

        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .message("Course deleted successfully")
                .status(HttpStatus.OK)
                .date(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/enable/{courseId}")
    public ResponseEntity<ApiResponse<Course>> enableCourse(@PathVariable UUID courseId) {
        Course enabledCourse = courseService.enableCourse(courseId);
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("You have successfully enabled this course")
                .status(HttpStatus.OK)
                .date(LocalDateTime.now())
                .payload(enabledCourse)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/disable/{courseId}")
    public ResponseEntity<ApiResponse<Course>> disableCourse(@PathVariable UUID courseId) {
        Course disableCourse = courseService.disableCourse(courseId);
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("You have successfully disable this course")
                .status(HttpStatus.OK)
                .date(LocalDateTime.now())
                .payload(disableCourse)
                .build();
        return ResponseEntity.ok(response);

    }

    @GetMapping("/search")
    public ResponseEntity<Page<Course>> searchCourses(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String creditHours,
            @RequestParam(required = false) Boolean isEnabled,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(courseService.searchCourses(name, creditHours, isEnabled, page, size));
    }


}


