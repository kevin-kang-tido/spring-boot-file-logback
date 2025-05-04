package com.apd.logbackspringbootfile.feature.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseRequest {

    private String courseCode;

    private String courseName;

    private String creditHours;

    private String description;

    private String createdBy;



}
