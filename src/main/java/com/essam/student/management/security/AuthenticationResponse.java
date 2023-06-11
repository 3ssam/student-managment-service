package com.essam.student.management.security;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String type;
    private String token;

    public AuthenticationResponse(String type, String token) {
        this.type = type;
        this.token = token;
    }

    public AuthenticationResponse() {
    }
}
