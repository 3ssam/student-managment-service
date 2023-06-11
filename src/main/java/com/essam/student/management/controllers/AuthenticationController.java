package com.essam.student.management.controllers;

import com.essam.student.management.security.AuthenticationRequest;
import com.essam.student.management.security.AuthenticationResponse;
import com.essam.student.management.security.JwtTokenProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
    private static Logger logger = LogManager.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public AuthenticationResponse authenticate(@Validated @RequestBody AuthenticationRequest request) throws Exception {
        logger.info("authenticate received request");
        var authenticationToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        return new AuthenticationResponse("Bearer", jwtTokenProvider.generateToken(authentication));
    }
}
