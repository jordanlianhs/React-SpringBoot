package com.example.test.view;
import java.util.List;

import com.example.test.model.Student;
public interface StudentView {
    public Student saveStudent(Student student);

    public List<Student> getAllStudents();
}
