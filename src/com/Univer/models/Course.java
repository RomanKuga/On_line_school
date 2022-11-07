package com.Univer.models;

public class Course {
    public static int calc;

    private static int id;
    public String subject;
    public Teacher teacher;
    public Lecture lecture;
    public AddMaterial add_material;
    public HomeWork home_work;

    public int Course(int id){
        calc++;
       return id;


    }

   /* public Course() {
        calc++;
    } */

}
