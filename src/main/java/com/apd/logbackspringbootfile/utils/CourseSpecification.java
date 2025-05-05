package com.apd.logbackspringbootfile.utils;

import com.apd.logbackspringbootfile.domain.Course;
import org.springframework.data.jpa.domain.Specification;

public class CourseSpecification {

   /**
    *     root.get("courseName"): Accesses the courseName field in the Course entity.
    *
    *     cb.lower(...): Converts both database field and input to lowercase for case-insensitive match.
    *
    *     cb.like(...): Performs a SQL LIKE (e.g., %math%).
    *
    *     courseName == null ? null: If input is null, return no filter (null means "ignore this clause").
    *
    * */


    public static Specification<Course> hasName(String courseName) {
        return (root, query, cb)
                -> courseName == null
                ? null
                : cb.like(cb.lower(root.get("courseName")), "%" + courseName.toLowerCase() + "%");
    }

    public static Specification<Course> hasCreditHours(String creditHours) {
        return (root, query, cb)
                -> creditHours == null
                ? null
                : cb.equal(root.get("creditHours"), creditHours);
    }

    public static Specification<Course> isEnabled(Boolean isEnabled) {
        return (root,query , cb)
                -> isEnabled == null
                ? null
                : cb.equal(root.get("isEnabled"), isEnabled);
    }

    public static Specification<Course> findByPriceGreaterThan(Double price) {
        return (root, query, cb)
                -> cb.greaterThan(root.get("price"), price);
    }
}
