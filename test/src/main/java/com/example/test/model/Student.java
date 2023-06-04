package com.example.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int totalcurrentcredits;
    private int totalcreditstograd;

    @OneToMany(mappedBy = "student")
    private List<Course> courses;

    public Student() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public int getTotalcurrentcredits() {
        return totalcurrentcredits;
    }
    public void setTotalcurrentcredits(int totalcurrentcredits) {
        
        for(Course course : courses){
            if(course.getGrade().equals("U")){
                continue;
            }
            totalcurrentcredits += course.getCredits();
        }
    }

    public int getTotalcreditstograd() {
        return totalcreditstograd;
    }

    public void setTotalcreditstograd(int totalcreditstograd) {
        this.totalcreditstograd = totalcreditstograd;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public float convertGrade(String grade){
        switch(grade){
            case "A+":
                return 5.0f;
            case "A":
                return 5.0f;
            case "A-":
                return 4.5f;
            case "B+":
                return 4.0f;
            case "B":
                return 3.5f;
            case "B-":
                return 3.0f;
            case "C+":
                return 2.5f;
            case "C":  
                return 2.0f;
            case "D+":
                return 1.5f;
            case "D":
                return 1.0f;
            case "F":
                return 0.0f;
            case "S":
                return 0.0f;
            case "U":
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    public float getCGPA(){
        float cgpa = 0;
        for(Course course : courses){
            cgpa += course.getCredits() * convertGrade(course.getGrade());
        }
        return cgpa;
    }

    public float getSGPA(int year, int sem){
        float sgpa = 0;
        for (Course course : courses){
            if(course.getYear() == year && course.getSem() == sem){
                sgpa += course.getCredits() * convertGrade(course.getGrade());
            }
        }
        return sgpa;
    }
    
}
