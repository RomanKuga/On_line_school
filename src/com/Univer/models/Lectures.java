package com.Univer.models;

public class Lectures {
    public static int calc;
   // private static long id;
    public Course id;
    public String nameLecture;

    public Course course;
    public Teacher teacher;
    public  Lectures(int id, String nameLecture) {
        this.nameLecture=nameLecture;
        this.id=new Course();


        calc++;
    }
}
