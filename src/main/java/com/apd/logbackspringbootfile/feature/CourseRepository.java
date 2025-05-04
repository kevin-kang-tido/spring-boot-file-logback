package com.apd.logbackspringbootfile.feature;

import com.apd.logbackspringbootfile.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course,UUID> {

    @Query("SELECT c FROM Course c WHERE c.isEnabled = true")
    Page<Course> findAllByEnabledTrue(Pageable pageable);

}
