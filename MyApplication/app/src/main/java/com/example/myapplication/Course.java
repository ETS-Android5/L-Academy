package com.example.myapplication;

public class Course {
    private String courseName;
    private String courseContent;
    private String difficulty; // Beginner, Intermediate, Advanced

    public Course(String courseName, String courseContent, String difficulty) {
        this.courseName = courseName;
        this.courseContent = courseContent;
        this.difficulty = difficulty;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseContent() {
        return courseContent;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseContent(String courseContent) {
        this.courseContent = courseContent;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
