package com.essam.student.management.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"id", "username", "email", "name", "grade"})
public interface StudentProjection {

    Long getId();

    public String getEmail();

    public String getName();

    public String getUsername();

    public String getGrade();
}
