package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;


    //  Optimized method to get all students with courses using batch fetching.

    public List<StudentCourse> getAllStudentsWithCourses() {
        return studentCourseRepository.findAllWithStudentsAndCourses();  // Use JPQL with JOIN FETCH
    }


     // Optimized method to find the student with the highest GPA directly via query.

    public Optional<Student> findStudentWithHighestGpa() {
        return studentRepository.findTopByOrderByGpaDesc(); // Fetches highest GPA directly
    }


     //  Optimized method to join student names using StringBuilder and Streams.

    public String joinStudentNames() {
        return studentRepository.findAll()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
