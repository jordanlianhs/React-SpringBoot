package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.Student;
import com.example.test.view.StudentView;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentView studentView;

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentView.saveStudent(student);
        return "New student is added to the database.";
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return studentView.getAllStudents();
    }
}
