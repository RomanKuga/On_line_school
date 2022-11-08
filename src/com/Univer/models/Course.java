package com.Univer.models;

public class Course {
    public static int calc;

    private  int courseID;
    public String subject;
    public Teacher teacher;
    public Lecture lecture;
    public AddMaterial add_material;
    public HomeWork home_work;

    public  Course(int courseID){
        calc++;
        this.courseID = courseID;

    }
    public int getCourseID() {
        return courseID;
    }

   /* public Course() {
        calc++;
    } */

}
