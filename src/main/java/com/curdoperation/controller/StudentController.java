package com.curdoperation.controller;


import com.curdoperation.entity.Student;
import com.curdoperation.message.ResponseMessage;
import com.curdoperation.repository.StudentRepository;
import com.curdoperation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentService studentService;


    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student saveStudent = studentRepository.save(student);
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }

    @GetMapping("/getalls")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> student = studentRepository.findAll();
        return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getbyids/{id}")
    public ResponseEntity<Optional<Student>> getByIDs(@PathVariable long id) {
        Optional<Student> studentId = studentRepository.findById(id);
        if (studentId.isPresent()) {
            return new ResponseEntity<>(studentId, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateByID(@RequestBody Student student, @PathVariable long id) {
        Optional<Student> studentID = studentRepository.findById(id);
        if (studentID.isPresent()) {
            return new ResponseEntity<>(studentService.updateStudents(student, id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletes/{id}")
    public ResponseEntity<Student> deleteByID(@PathVariable long id) {
        try {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        }
    }
  


}

