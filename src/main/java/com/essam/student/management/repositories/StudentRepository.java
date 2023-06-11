package com.essam.student.management.repositories;

import com.essam.student.management.models.Student;
import com.essam.student.management.projection.StudentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByUsername(String username);

    StudentProjection getUserById(Long id);

    StudentProjection getStudentById(Long id);

    List<StudentProjection> findAllBy();
}
