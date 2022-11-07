package com.Univer.models;

public class AddMaterial {
    public static int calc;
    private static long id;
    public String name_Add_materials;
    public Lecture lectures;
    public Course course;
    public AddMaterial(String name_Add_materials, Lecture lectures, Course course) {
        this.name_Add_materials=name_Add_materials;
        this.lectures=lectures;
        this.course=course;
        calc++;
    }
}
