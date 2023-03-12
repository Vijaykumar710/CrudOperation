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

/////=====================================NEW Repository========================================================/////////////


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
    //=========================================Get,post by Service class==============================================================//

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student) {
        studentService.add(student);
    }

    @GetMapping("/getall")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getByID(@PathVariable long id) {
        return studentService.getById(id);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

  /*  @DeleteMapping("/delrepo/{id}")
    public void deleteByIDRepo(@PathVariable Long id){
        studentRepository.deleteById(id);
    }*/

    /* @GetMapping("/stud/{id}")
      public Student getByIDStudent(@PathVariable Long id) {
          return studentService.getStudentById(id);
      }*/
    /////===============================Message=============================================================================////////
    @PostMapping("/studentmessage")
    public ResponseEntity<ResponseMessage> createStudentMessage(@RequestBody Student student) {
        String message = "";
        Student saveStudent = studentRepository.save(student);
        message = "created the Id: " + saveStudent.getId();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }
}
/*Total update without writing in service class
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateByID(@RequestBody Student student,@PathVariable long id) {
        Optional<Student> studentID = studentRepository.findById(id);
        if(studentID.isPresent()){
            Student _student = studentID.get();
            _student.setName(student.getName());
            _student.setId(student.getId());
            _student.setRole(student.getRole());
            _student.setNumber(student.getNumber());
            return new ResponseEntity<>(studentRepository.save(_student), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
