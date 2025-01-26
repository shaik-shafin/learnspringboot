package com.shaik.acknowledge.hibernatemappings.manytoone.service;

import com.shaik.acknowledge.hibernatemappings.manytoone.domain.Student;
import com.shaik.acknowledge.hibernatemappings.manytoone.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {

        studentRepository.save(student);
    }

    public Student getStudent(Integer studentId) {

        return studentRepository.findById(studentId).get();
    }

    public void deleteStudent(Integer studentId) {

        studentRepository.deleteById(studentId);
    }
}
