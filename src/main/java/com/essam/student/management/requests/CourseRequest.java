package com.essam.student.management.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    @NotNull(message = "name is mandatory")
    private String name;

    @NotNull(message = "startDate is mandatory")
    private Date startDate;

    @NotNull(message = "endDate is mandatory")
    private Date endDate;

    private String day;
}
