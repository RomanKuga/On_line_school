package com.Univer.models;

public class Course {
    public static int calc;
    public static int calc1;
    private static int id;
    public String subject;
    public Teacher teacher;
    public Lectures lecture;
    public AddMaterials add_material;
    public HomeWork home_work;

    public int Course(int id){
        calc++;
       return id;


    }

   /* public Course() {
        calc1++;
    } */

}
