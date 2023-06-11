package com.essam.student.management.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AuthorityRequest {
    @NotBlank(message = "This field is required field")
    private String name;
    @NotBlank(message = "This field is required field")
    private String nameDescription;
    @NotNull(message = "This field is required field")
    private Boolean status;
}
