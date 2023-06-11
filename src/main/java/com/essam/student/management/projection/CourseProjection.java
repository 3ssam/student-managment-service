package com.essam.student.management.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@JsonPropertyOrder({"id", "courseName", "startDate", "endDate", "day"})
@ApiModel
public interface CourseProjection {

    @ApiModelProperty(position = 1)
    Long getId();

    @ApiModelProperty(position = 2)
    public String getCourseName();

    @ApiModelProperty(position = 3)
    public String getStartDate();

    @ApiModelProperty(position = 4)
    public String getEndDate();

    @ApiModelProperty(position = 5)
    public String getDay();

}
