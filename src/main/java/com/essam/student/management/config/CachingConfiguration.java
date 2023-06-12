package com.essam.student.management.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class CachingConfiguration {

    public final static List<String> CACHE_NAMES = new ArrayList<>(List.of(
            "authorities",
            "authority",
            "course",
            "courses",
            "export_courses",
            "role",
            "roles",
            "role_by_id",
            "role_by_name",
            "student",
            "students",
            "student_courses",
            "download_student_courses"
    ));

    @Value("${cache.max.size}")
    private int maximumSize;
    @Value("${cache.expiration.time}")
    private int expirationTime;

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("student_courses");
        cacheManager.setCacheNames(CACHE_NAMES);
        cacheManager.setCaffeine(
                Caffeine.newBuilder()
                        .maximumSize(maximumSize)
                        .expireAfterWrite(expirationTime, TimeUnit.MINUTES)
        );
        return cacheManager;
    }


}
