package com.nickcassandra.service;

import com.nickcassandra.entity.Student;
import com.nickcassandra.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentDelegator implements Delegator {

    @Autowired
    private StudentRepo studentRepo;

    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok(studentRepo.findAll());
    }

    public ResponseEntity<Student> createStudent(Student student) {
        System.out.println("Student: " + student);
        return ResponseEntity.ok(studentRepo.save(student));
    }

    public ResponseEntity<Student> getStudent(Long studentId) {
        return ResponseEntity.ok(studentRepo.findById(studentId).get());
    }

    public ResponseEntity<Student> updateStudent(Student student) {

        Student studentToUpdate = studentRepo.findById(student.getStudentId()).get();
        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setLastName(student.getLastName());
        studentToUpdate.setEmail(student.getEmail());
        return ResponseEntity.ok(studentRepo.save(studentToUpdate));
    }


    public ResponseEntity<Student> deleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
        return ResponseEntity.ok().build();
    }
}
