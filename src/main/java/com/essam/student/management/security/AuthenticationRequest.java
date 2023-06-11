package com.essam.student.management.security;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
