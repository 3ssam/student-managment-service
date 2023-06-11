package com.essam.student.management.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {
    @NotBlank(message = "This field is required field")
    private String email;
    @NotBlank(message = "This field is required field")
    private String username;
    @NotBlank(message = "This field is required field")
    private String password;
    @NotBlank(message = "This field is required field")
    private String name;
    @NotBlank(message = "This field is required field")
    private String roleName;
}
