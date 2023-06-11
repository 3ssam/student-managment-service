package com.essam.student.management.projection;

import com.essam.student.management.models.Course;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


@JsonPropertyOrder({"id", "username", "email", "name", "grade", "age", "courses"})
@ApiModel
public interface StudentProjection {

    @ApiModelProperty(position = 1)
    Long getId();

    @ApiModelProperty(position = 2)
    public String getEmail();

    @ApiModelProperty(position = 3)
    public String getName();

    @ApiModelProperty(position = 4)
    public String getUsername();

    @ApiModelProperty(position = 5)
    public String getGrade();

    @ApiModelProperty(position = 6)
    public Integer getAge();

    @ApiModelProperty(position = 7)
    public List<Course> getCourses();
}
