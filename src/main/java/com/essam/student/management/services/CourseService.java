package com.essam.student.management.services;

import com.essam.student.management.models.Course;
import com.essam.student.management.models.Student;
import com.essam.student.management.projection.CourseProjection;
import com.essam.student.management.repositories.CourseRepository;
import com.essam.student.management.requests.CourseRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public CourseProjection createCourse(CourseRequest request) throws Exception {
        Course course = createCourseObject(request, null);
        course = courseRepository.save(course);
        return courseRepository.getCourseById(course.getId());
    }

    private Course createCourseObject(CourseRequest request, Course course) throws Exception {
        if (course == null) {
            course = new Course();
        }
        course.setCourseName(request.getName());
        course.setDay(request.getDay());
        course.setEndDate(request.getEndDate());
        course.setStartDate(request.getStartDate());
        return course;
    }

    @Transactional
    public CourseProjection updateCourse(CourseRequest request, Long id) throws Exception {
        Course course = getCourseIfExist(id);
        course = createCourseObject(request, course);
        course = courseRepository.save(course);
        return courseRepository.getCourseById(course.getId());
    }

    public List<CourseProjection> getAllCourses() {
        return courseRepository.findAllBy();
    }

    public List<CourseProjection> getAllCoursesOfStudent(Student student) {
        return courseRepository.findAllBy();
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public CourseProjection getCourse(Long id) throws Exception {
        return getCourseProjectionIfExist(id);
    }

    @Transactional
    public CourseProjection deleteCourse(Long id) throws Exception {
        CourseProjection courseProjection = getCourseProjectionIfExist(id);
        courseRepository.deleteById(courseProjection.getId());
        return courseProjection;
    }


    public Course getCourseIfExist(Long id) throws Exception {
        Course course = courseRepository.findById(id).get();
        if (course == null) {
            throw new Exception("Course not found and this Id not exist");
        }
        return course;
    }

    private CourseProjection getCourseProjectionIfExist(Long id) throws Exception {
        CourseProjection courseProjection = courseRepository.getCourseById(id);
        if (courseProjection == null) {
            throw new Exception("Course not found and this Id not exist");
        }
        return courseProjection;
    }


}
