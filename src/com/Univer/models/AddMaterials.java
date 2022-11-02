package com.Univer.models;

public class AddMaterials {
    public static int calc;
    private static long id;
    public String name_Add_materials;
    public Lectures lectures;
    public Course course;
    public AddMaterials(String name_Add_materials, Lectures lectures, Course course) {
        this.name_Add_materials=name_Add_materials;
        this.lectures=lectures;
        this.course=course;
        calc++;
    }
}
