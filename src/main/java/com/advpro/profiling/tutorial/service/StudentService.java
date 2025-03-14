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


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;


    // Optimized method to get all students with their courses in a single query
    //  Reduces N+1 queries to just 1 via JPQL JOIN FETCH

    public List<StudentCourse> getAllStudentsWithCourses() {

        return studentCourseRepository.findAllWithStudentsAndCourses();
    }


    // Optimized method to find the student with the highest GPA directly
     // This avoids fetching all students into memory and looping.

    public Optional<Student> findStudentWithHighestGpa() {

        return studentRepository.findTopByOrderByGpaDesc();
    }


      //Optimized method to join all student names into a single String.
     // Uses parallelStream() to potentially speed up large list processing


    public String joinStudentNames() {
        return studentRepository.findAll()
                .parallelStream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
    }


     // Fetches all students (if needed by other endpoints).

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
