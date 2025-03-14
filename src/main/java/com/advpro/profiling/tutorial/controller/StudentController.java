package com.advpro.profiling.tutorial.controller;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api") // Set a base path to avoid confusion
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/all-student-request")
    public ResponseEntity<List<StudentCourse>> getAllStudentsWithCourses() {
        List<StudentCourse> studentCourses = studentService.getAllStudentsWithCourses();
        return ResponseEntity.ok(studentCourses);
    }


    @GetMapping("/all-student")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }


    @GetMapping("/highest-gpa")
    public ResponseEntity<Student> getHighestGpaStudent() {
        Optional<Student> studentWithHighestGpa = studentService.findStudentWithHighestGpa();
        return studentWithHighestGpa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/all-student-name")
    public ResponseEntity<String> getAllStudentNames() {
        String joinedStudentNames = studentService.joinStudentNames();
        return ResponseEntity.ok(joinedStudentNames);
    }
}
