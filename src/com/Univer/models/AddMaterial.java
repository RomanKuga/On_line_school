package com.Univer.models;

public class AddMaterial extends MasterModels{
    private static int calc;
    private int id;
    private String nameAddMaterials;
    private Lecture lectures;
    private Course course;
    public AddMaterial(int id, String nameAddMaterials, Lecture lectures, Course course) {
        super(id);
        this.nameAddMaterials=nameAddMaterials;
        this.lectures=lectures;
        this.course=course;
        calc++;
    }

    public static int getCalcAddMaterial() {

        return calc;
    }

       public int getIdAddMaterial() {
        return id;
    }


    public String getNameAddMaterials() {
        return nameAddMaterials;
    }

    public Lecture getLecturesAddMaterial() {

        return lectures;
    }

    public Course getCourseAddMaterial() {

        return course;
    }
}
