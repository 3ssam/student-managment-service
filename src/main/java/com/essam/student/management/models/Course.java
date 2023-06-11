package com.essam.student.management.models;

import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Course extends BaseEntity {

    private static final long serialVersionUID = 4258129832216418499L;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    private String courseName;
}
