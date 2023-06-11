package com.essam.student.management.config;

import com.essam.student.management.models.User;
import com.essam.student.management.repositories.UserRepository;
import com.essam.student.management.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditConfiguration {
    @Autowired
    private UserRepository userRepository;

    @Bean
    AuditorAware<User> auditorProvider() {
        if (CurrentUser.getPrincipal() == null) {
            return () -> Optional.of(userRepository.getOne(1L));
        }
        return () -> Optional.of(userRepository.getOne(CurrentUser.getId()));
    }
}
