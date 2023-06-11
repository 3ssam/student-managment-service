package com.essam.student.management.controllers;

import com.essam.student.management.requests.CourseRequest;
import com.essam.student.management.response.ApiResponse;
import com.essam.student.management.services.CourseService;
import com.essam.student.management.util.PdfGenerator;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@Api(tags = "Course API", description = "this API for Course CRUD operations")
@RequestMapping("course")
public class CourseController {

    private static Logger logger = LogManager.getLogger(CourseController.class);
    @Autowired
    private CourseService courseService;

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_Course')")
    public ApiResponse createCourse(@Validated @RequestBody CourseRequest request) throws Exception {
        logger.info("createCourse received request");
        return ApiResponse.created(courseService.createCourse(request));
    }

    @PreAuthorize("hasAuthority('UPDATE_Course')")
    @PutMapping("{courseId}")
    public ApiResponse updateCourse(@PathVariable Long courseId, @Validated @RequestBody CourseRequest request) throws Exception {
        logger.info("updateCourse received request");
        return ApiResponse.updated(courseService.updateCourse(request, courseId));
    }

    @PreAuthorize("hasAuthority('DELETE_Course')")
    @DeleteMapping("{courseId}")
    public ApiResponse deleteCourse(@PathVariable Long courseId) throws Exception {
        logger.info("deleteCourse received request");
        return ApiResponse.deleted(courseService.deleteCourse(courseId));
    }

    @PreAuthorize("hasAuthority('RETRIEVE_Course')")
    @GetMapping({"{courseId}"})
    public ApiResponse getCourse(@PathVariable Long courseId) throws Exception {
        logger.info("getCourse received request");
        return ApiResponse.ok(courseService.getCourse(courseId));
    }

    @PreAuthorize("hasAuthority('RETRIEVE_Courses')")
    @GetMapping()
    public ApiResponse getAllCourses() {
        logger.info("getAllCourses received request");
        return ApiResponse.ok(courseService.getAllCourses());
    }

    @PreAuthorize("hasAuthority('DOWNLOAD_Courses')")
    @GetMapping("export")
    public void downloadAllCourses(HttpServletResponse response) throws IOException {
        logger.info("downloadAllCourses received request");
        response = PdfGenerator.getPDFResponseWithMetaData(response);
        PdfGenerator.generate(courseService.getCourses(), response);
    }
}
