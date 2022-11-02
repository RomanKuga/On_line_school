package com.Univer.models;

public class Course {
    public static int calc;
    public static int calc1;
    private static long id;
    public String subject;
    public Teacher teacher;
    public Lectures lecture;
    public AddMaterials add_material;
    public HomeWork home_work;

    public Course(String subject, Teacher teacher, Lectures lecture, AddMaterials add_material, HomeWork home_work){
        this.subject=subject;
        this.teacher=teacher;
        this.lecture=lecture;
        this.add_material= add_material;
        this.home_work=home_work;
        calc++;

    }

    public Course() {
        calc1++;
    }

}
