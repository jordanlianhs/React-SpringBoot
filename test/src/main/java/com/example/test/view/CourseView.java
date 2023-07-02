package com.example.test.view;
import java.util.List;

import com.example.test.model.Course;
public interface CourseView {
    public Course saveCourse(Course course);

    public List<Course> getAllCourses();
}
