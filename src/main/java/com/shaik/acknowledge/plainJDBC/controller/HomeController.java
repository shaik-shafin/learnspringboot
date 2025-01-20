package com.shaik.acknowledge.plainJDBC.controller;

import com.shaik.acknowledge.plainJDBC.dao.StudentDao;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plain-jdbc")
public class HomeController {

    private final StudentDao studentDao = new StudentDao();

    @GetMapping("test")
    public String getRequest(){
        return "server is working";
    }

    @GetMapping("read-students")
    public String readStudents(){

        return studentDao.readStudent();
    }

    @PostMapping("create-student")
    public String createTable(@RequestParam String studentName){
        studentDao.createStudent(studentName);
        return "Student created successfully";
    }


}
