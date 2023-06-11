package com.essam.student.management.repositories;

import com.essam.student.management.models.Course;
import com.essam.student.management.projection.CourseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    CourseProjection getCourseById(Long id);

    List<CourseProjection> findAllBy();

}
