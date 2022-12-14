package com.Univer.models;

public class Course {
    public static int calc;

    private  int courseID;
    private String subject;
    private Teacher teacher;
    private Lecture lecture;
    private AddMaterial add_material;
    private HomeWork home_work;

    public  Course(int courseID){
        calc++;
        this.courseID = courseID;

    }
    public int getCourseID() {
        return courseID;
    }

    public static int getCalcCourse() {
        return calc;
    }
}
