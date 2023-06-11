package com.essam.student.management.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Course extends BaseEntity {

    private static final long serialVersionUID = 4258129832216418499L;

    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    private String courseName;

    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date startDate;

    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date endDate;

    private String day;
}
