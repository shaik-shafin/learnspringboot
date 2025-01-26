package com.shaik.acknowledge.hibernatemappings.manytoone.controller;

import com.shaik.acknowledge.hibernatemappings.manytoone.domain.Project;
import com.shaik.acknowledge.hibernatemappings.manytoone.domain.Student;
import com.shaik.acknowledge.hibernatemappings.manytoone.service.ProjectService;
import com.shaik.acknowledge.hibernatemappings.manytoone.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hibernate-mapping/many-to-one")
public class ManyToOneController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("all-projects")
    public List<Project> getAllProjects() {

        return projectService.getAllProjects();
    }

    @GetMapping("project/{projectId}")
    public Project getProject(@PathVariable Integer projectId) {

        return projectService.getProject(projectId);
    }

    @PostMapping("save-project")
    public String saveProject(Project project) {

        projectService.saveProject(project);

        return "Project saved successfully";
    }

    @PutMapping("update-project")
    public String updateProject(Project project) {

        projectService.saveProject(project);

        return "Project updated successfully";
    }

    @DeleteMapping("delete-project/{projectId}")
    public String deleteProject(@PathVariable Integer projectId) {

        projectService.deleteProject(projectId);

        return "Project deleted successfully";
    }

    @GetMapping("student/{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {

        return studentService.getStudent(studentId);
    }

    @GetMapping("all-students")
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    @PostMapping("save-student")
    public String saveStudent(Student student) {

        studentService.saveStudent(student);

        return "Student saved successfully";
    }

    @PutMapping("update-student")
    public String updateStudent(Student student) {

        studentService.saveStudent(student);

        return "Student updated successfully";
    }

    @DeleteMapping("delete-student/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId) {

        studentService.deleteStudent(studentId);

        return "Student deleted successfully";
    }

}
