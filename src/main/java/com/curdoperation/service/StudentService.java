package com.curdoperation.service;

import com.curdoperation.entity.Student;
import com.curdoperation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void add(Student student) {//post
        studentRepository.save(student);
    }

    public List<Student> getAllStudent() {//GetAll
        return studentRepository.findAll();
    }

    public Student getById(long id) {
        Optional<Student> num = studentRepository.findById(id);
        if (num.isPresent()) {
            return num.get();
        }
        return null;
    }

    public Student updateStudent(Student student, Long id) {
        Optional<Student> idNumber = studentRepository.findById(id);
        if (idNumber.isPresent()) {
            student.setName(student.getName());
            student.setId(student.getId());
            student.setRole(student.getRole());
            student.setNumber(student.getNumber());
            studentRepository.save(student);
            return student;
        } else {
            return null;
        }
    }


    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    
    public Student updateStudents(Student student, long id) {
        Optional<Student> idNumber = studentRepository.findById(id);
        if (idNumber.isPresent()) {
            student.setName(student.getName());
            student.setId(student.getId());
            student.setRole(student.getRole());
            student.setNumber(student.getNumber());
            studentRepository.save(student);
            return student;
        } else {
            return null;
        }
    }
}
