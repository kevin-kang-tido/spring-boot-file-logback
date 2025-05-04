package com.apd.logbackspringbootfile.feature.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseResponse  {

    private UUID courseId;

    private String courseCode;

    private String courseName;

    private String creditHours;

    private String description;



}
