package com.essam.student.management.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"id", "courseName"})
public interface CourseProjection {

    Long getId();

    public String getCourseName();
}
