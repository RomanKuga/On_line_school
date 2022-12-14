package com.Univer.models;

public class AddMaterial {
    private static int calc;
    private static long id;
    private String name_Add_materials;
    private Lecture lectures;
    private Course course;
    public AddMaterial(String name_Add_materials, Lecture lectures, Course course) {
        this.name_Add_materials=name_Add_materials;
        this.lectures=lectures;
        this.course=course;
        calc++;
    }

    public static int getCalcAddMaterial() {
        return calc;
    }

       public static long getIdAddMaterial() {
        return id;
    }

    public String getName_Add_materials() {
        return name_Add_materials;
    }

    public Lecture getLecturesAddMaterial() {
        return lectures;
    }

    public Course getCourseAddMaterial() {
        return course;
    }
}
