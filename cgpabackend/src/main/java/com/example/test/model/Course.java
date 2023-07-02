package com.example.test.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {
    @Id
    private String coursecode;
    private String name;
    private int credits;
    private String grade;
    private int year;
    private int sem;

    @ManyToOne
    private Student student;

    public Course() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCoursecode() {
        return coursecode;
    }
    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getSem() {
        return sem;
    }
    public void setSem(int sem) {
        this.sem = sem;
    }

    
}
