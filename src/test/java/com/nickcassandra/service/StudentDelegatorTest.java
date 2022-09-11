package com.nickcassandra.service;

import com.nickcassandra.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDelegatorTest {

    @Autowired
    private StudentDelegator studentDelegator;

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


}