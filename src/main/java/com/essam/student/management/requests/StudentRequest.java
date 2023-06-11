package com.essam.student.management.requests;

import com.essam.student.management.security.password.annotation.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    @NotNull(message = "name is mandatory")
    private String name;

    @NotNull(message = "username is mandatory")
    private String username;

    @ValidPassword
    @NonNull
    @NotBlank(message = "New password is mandatory")
    private String password;

    @ValidPassword
    @NonNull
    @NotBlank(message = "Confirm Password is mandatory")
    private String confirmPassword;

    @Email
    private String email;
    private String grade;
    private Integer age;
}
