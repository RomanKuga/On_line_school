package com.univer.models;

public class Course extends MasterModels{
    private static int calc;
    private String name;

    public  Course(int courseID, String name){
        super(courseID);
        this.name=name;
        calc++;
    }
    public String getName() {
        return name;
    }

    public int getCourseID() {

        return super.getID();
    }

    public static int getCalcCourse() {

        return calc;
    }
}
