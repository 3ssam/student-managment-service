package com.essam.student.management.controllers;

import com.essam.student.management.models.Course;
import com.essam.student.management.requests.StudentRequest;
import com.essam.student.management.response.ApiResponse;
import com.essam.student.management.services.StudentService;
import com.essam.student.management.util.PdfGenerator;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "Student API", description = "this API for Student CRUD operations")
@RequestMapping("student")
public class StudentController {

    private static Logger logger = LogManager.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    @PostMapping("signup")
    public ApiResponse createStudent(@Validated @RequestBody StudentRequest request) throws Exception {
        logger.info("createStudent received request");
        return ApiResponse.created(studentService.createStudent(request));
    }

    @PreAuthorize("hasAuthority('UPDATE_Student')")
    @PutMapping("{studentId}")
    public ApiResponse updateStudent(@PathVariable Long studentId, @Validated @RequestBody StudentRequest request) throws Exception {
        logger.info("updateStudent received request");
        return ApiResponse.updated(studentService.updateStudent(request, studentId));
    }

    @PreAuthorize("hasAuthority('DELETE_Student')")
    @DeleteMapping("{studentId}")
    public ApiResponse deleteStudent(@PathVariable Long studentId) throws Exception {
        logger.info("deleteStudent received request");
        return ApiResponse.deleted(studentService.deleteStudent(studentId));
    }

    @PreAuthorize("hasAuthority('RETRIEVE_Student')")
    @GetMapping({"{studentId}"})
    public ApiResponse getStudent(@PathVariable Long studentId) throws Exception {
        logger.info("getStudent received request");
        return ApiResponse.ok(studentService.getStudent(studentId));
    }

    @PreAuthorize("hasAuthority('RETRIEVE_Students')")
    @GetMapping()
    public ApiResponse getAllStudents() {
        logger.info("getAllStudents received request");
        return ApiResponse.ok(studentService.getAllStudents());
    }

    @PreAuthorize("hasAuthority('RETRIEVE_Students_Courses')")
    @GetMapping({"{studentId}/courses"})
    public ApiResponse getStudentCourses(@PathVariable Long studentId) throws Exception {
        logger.info("getStudentCourses received request");
        return ApiResponse.ok(studentService.getStudentCourses(studentId));
    }

    @PreAuthorize("hasAuthority('DOWNLOAD_Students_Courses')")
    @GetMapping({"{studentId}/courses/export"})
    public void exportCoursesOfStudent(HttpServletResponse response, @PathVariable Long studentId) throws Exception {
        logger.info("exportCoursesOfStudent received request");
        response = PdfGenerator.getPDFResponseWithMetaData(response);
        PdfGenerator.generate((List<Course>) studentService.exportCoursesOfStudent(studentId), response);
    }

    @PreAuthorize("hasAuthority('ENROLL_Course')")
    @PutMapping({"{studentId}/enrollCourse"})
    public ApiResponse enrollCourse(@PathVariable Long studentId, @RequestParam Long courseId) throws Exception {
        logger.info("enrollCourse received request");
        return ApiResponse.ok(studentService.enrollCourse(studentId, courseId));
    }

    @PreAuthorize("hasAuthority('CANCEL_Course')")
    @DeleteMapping({"{studentId}/cancelCourse"})
    public ApiResponse cancelCourse(@PathVariable Long studentId, @RequestParam Long courseId) throws Exception {
        logger.info("cancelCourse received request");
        return ApiResponse.ok(studentService.cancelCourse(studentId, courseId));
    }

}
