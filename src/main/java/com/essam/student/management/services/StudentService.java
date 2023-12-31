package com.essam.student.management.services;

import com.essam.student.management.models.Course;
import com.essam.student.management.models.Student;
import com.essam.student.management.projection.StudentProjection;
import com.essam.student.management.repositories.StudentRepository;
import com.essam.student.management.requests.StudentRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private CourseService courseService;

    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setCourseService(@Lazy CourseService courseService) {
        this.courseService = courseService;
    }

    @Transactional
    public StudentProjection createStudent(StudentRequest request) throws Exception {
        Student student = createStudentObject(request, null);
        student.setUsername(request.getUsername());
        student.setCourses(new ArrayList<>());
        student.setPassword(passwordEncoder.encode(request.getPassword()));
        student = studentRepository.save(student);
        return studentRepository.getStudentById(student.getId());
    }

    private Student createStudentObject(StudentRequest request, Student student) throws Exception {
        if (student == null) {
            student = new Student();
        }
        if (studentRepository.existsByUsername(request.getUsername())) {
            throw new Exception("Username already exist");
        }
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setPassword(request.getPassword());
        student.setActivated(true);
        student.setSuspended(false);
        student.setGrade(request.getGrade());
        student.setAge(request.getAge());
        student.setRole(roleService.getRoleObject(2L));
        return student;
    }

    @Transactional
    public StudentProjection updateStudent(StudentRequest request, Long id) throws Exception {
        Student student = getStudentIfExist(id);
        student = createStudentObject(request, student);
        student = studentRepository.save(student);
        return studentRepository.getStudentById(student.getId());
    }

    public List<StudentProjection> getAllStudents() {
        return studentRepository.findAllBy();
    }

    public StudentProjection getStudent(Long id) throws Exception {
        return getStudentProjectionIfExist(id);
    }

    @Transactional
    public StudentProjection deleteStudent(Long id) throws Exception {
        StudentProjection studentProjection = getStudentProjectionIfExist(id);
        studentRepository.deleteById(studentProjection.getId());
        return studentProjection;
    }


    public Student getStudentIfExist(Long id) throws Exception {
        Student student = studentRepository.findById(id).get();
        if (student == null) {
            throw new Exception("Student not found and this Id not exist");
        }
        return student;
    }

    private StudentProjection getStudentProjectionIfExist(Long id) throws Exception {
        StudentProjection studentProjection = studentRepository.getStudentById(id);
        if (studentProjection == null) {
            throw new Exception("Student not found and this Id not exist");
        }
        return studentProjection;
    }

    public Object getStudentCourses(Long id) throws Exception {
        return getStudentIfExist(id).getCourses();
    }

    public Object exportCoursesOfStudent(Long id) throws Exception {
        return getStudentIfExist(id).getCourses();
    }

    @Transactional
    public StudentProjection enrollCourse(Long studentId, Long courseId) throws Exception {
        Student student = getStudentIfExist(studentId);
        Course course = courseService.getCourseIfExist(courseId);
        student.getCourses().add(course);
        studentRepository.save(student);
        return studentRepository.getStudentById(student.getId());
    }

    @Transactional
    public StudentProjection cancelCourse(Long studentId, Long courseId) throws Exception {
        Student student = getStudentIfExist(studentId);
        Course course = courseService.getCourseIfExist(courseId);
        student.getCourses().remove(course);
        studentRepository.save(student);
        return studentRepository.getStudentById(student.getId());
    }

}
