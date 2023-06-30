package com.example.test.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.model.Course;
import com.example.test.repository.CourseRepository;

@Service
public class CourseViewImpl implements CourseView {
    
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
}
