package com.Univer.models;

public class Course extends MasterModels{
    private static int calc;

   // private  int courseID;
    private String subject;
    private Lecture lecture;
    private AddMaterial addMaterial;
    private HomeWork homeWork;



    public  Course(int courseID){
        super(courseID);
        calc++;

    }

    public int getCourseID() {

        return super.getID();
    }

    public static int getCalcCourse() {

        return calc;
    }
}
