package com.essam.student.management.controllers;

import com.essam.student.management.requests.StudentRequest;
import com.essam.student.management.response.ApiResponse;
import com.essam.student.management.services.StudentService;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags = "Student API", description = "this API for Student CRUD operations")
@RequestMapping("student")
public class StudentController {

    private static Logger logger = LogManager.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ApiResponse createStudent(@Validated @RequestBody StudentRequest request) throws Exception {
        logger.info("createStudent received request");
        return ApiResponse.created(studentService.createStudent(request));
    }

    @PutMapping("{studentId}")
    public ApiResponse updateStudent(@PathVariable Long studentId, @Validated @RequestBody StudentRequest request) throws Exception {
        logger.info("updateStudent received request");
        return ApiResponse.updated(studentService.updateStudent(request, studentId));
    }

    @DeleteMapping("{studentId}")
    public ApiResponse deleteStudent(@PathVariable Long studentId) throws Exception {
        logger.info("deleteStudent received request");
        return ApiResponse.deleted(studentService.deleteStudent(studentId));
    }

    @GetMapping({"{studentId}"})
    public ApiResponse getStudent(@PathVariable Long studentId) throws Exception {
        logger.info("getStudent received request");
        return ApiResponse.ok(studentService.getStudent(studentId));
    }

    @GetMapping()
    public ApiResponse getAllStudents() {
        logger.info("getAllStudents received request");
        return ApiResponse.ok(studentService.getAllStudents());
    }
}
