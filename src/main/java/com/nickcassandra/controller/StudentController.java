package com.nickcassandra.controller;

import com.nickcassandra.entity.Student;
import com.nickcassandra.service.StudentDelegator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController("/")
public class StudentController {

    @Autowired
    private StudentDelegator studentDelegator;

    @GetMapping
    public String getStudent() {
        return "Hello World";
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return studentDelegator.getAllStudents();
    }

    @GetMapping(value = "/student/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
        return studentDelegator.getStudent(studentId);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return studentDelegator.createStudent(student);
    }

    @PutMapping(value = "/update", consumes = "application/json")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return studentDelegator.updateStudent(student);
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long studentId) {
        return studentDelegator.deleteStudent(studentId);
    }
}
