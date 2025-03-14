package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Course;
import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.CourseRepository;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author muhammad.khadafi
 */
@Service
public class DataSeedService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    private static final int NUMBER_OF_STUDENTS = 5_000;
    private static final int NUMBER_OF_COURSE = 5;
    private static final int MAX_COURSES_PER_STUDENT = 2;  // Reduce for efficiency

    public void seedStudent() {
        Faker faker = new Faker(new Locale("in-ID"));
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            Student student = new Student();
            student.setStudentCode(faker.code().ean8());
            student.setName(faker.name().fullName());
            student.setFaculty(faker.educator().course());
            student.setGpa(faker.number().randomDouble(2, 2, 4));

            students.add(student);
        }

        studentRepository.saveAll(students);
    }

    public void seedCourse() {
        Faker faker = new Faker(new Locale("in-ID"));
        List<Course> courses = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_COURSE; i++) {
            Course course = new Course();
            course.setCourseCode(faker.code().ean8());
            course.setName(faker.book().title());
            course.setDescription(faker.lorem().sentence());

            courses.add(course);
        }

        courseRepository.saveAll(courses);
    }

    public void seedStudentCourses() {
        List<Student> students = studentRepository.findAll();
        List<Course> courses = courseRepository.findAll();
        List<StudentCourse> studentCourses = new ArrayList<>();

        Random random = new Random();

        for (Student student : students) {
            List<Course> selectedCourses = random.ints(0, courses.size())
                    .distinct()
                    .limit(MAX_COURSES_PER_STUDENT)  // Reduce load on database
                    .mapToObj(courses::get)
                    .collect(Collectors.toList());

            for (Course course : selectedCourses) {
                StudentCourse studentCourse = new StudentCourse(student, course);
                studentCourses.add(studentCourse);
            }
        }

        studentCourseRepository.saveAll(studentCourses);
    }
}
