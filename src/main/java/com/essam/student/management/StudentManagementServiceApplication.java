package com.essam.student.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class StudentManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementServiceApplication.class, args);
    }

}
