package com.nickcassandra.service;

import com.nickcassandra.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDelegatorTest {

    @Autowired
    private StudentDelegator studentDelegator;

    @BeforeEach
    void setUp() {

        Student student = Student
                .builder()
                .studentId(2L)
                .email("nicolas.cinera@gmail.com")
                .firstName("Nicolas")
                .lastName("Cinera")
                .build();

    }

    @Test
    public void createStudent() {
        Student student = Student
                .builder()
                .studentId(1L)
                .email("cineran@usf.edu")
                .firstName("Nick")
                .lastName("Cinera")
                .build();

        studentDelegator.createStudent(student);
        Student fetchStudent = studentDelegator.getStudent(1L).getBody();
        assertEquals(student.getEmail(), fetchStudent.getEmail());
    }

    @Test
    public void updateStudent() {
        String newEmail = "cineran@usf.edu";
        Student student = Student
                .builder()
                .studentId(2L)
                .email(newEmail)
                .firstName("Nick")
                .lastName("Cinera")
                .build();

        studentDelegator.updateStudent(student);
        Student fetchStudent = studentDelegator.getStudent(2L).getBody();
        assertEquals(newEmail, Objects.requireNonNull(fetchStudent).getEmail());
    }

    @Test
    public void deleteStudent() {
        studentDelegator.deleteStudent(2L);
        Student fetchStudent = studentDelegator.getStudent(2L).getBody();
        assertNull(fetchStudent);
    }
}