package com.essam.student.management.security;

import com.essam.student.management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CurrentUser {

    @Autowired
    private static UserRepository userRepository;


    public static long getId() {
        return getPrincipal().map(MyUserDetails::getId).orElse((long) -1);
    }


    public static Optional<MyUserDetails> getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return Optional.ofNullable(authentication).map(auth -> ((MyUserDetails) auth.getPrincipal()));
    }
}
