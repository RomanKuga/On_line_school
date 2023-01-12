package com.univer.models;

public class HomeWork extends MasterModels {
    private static int calc;
    private int id;

    private String nameHomeWork;
    private Lecture lectures;
    private Course courseID;
    public HomeWork( int id, Course courseID, String nameHomeWork, Lecture lectures ) {
        super(id);
        this.courseID=courseID;
        this.nameHomeWork=nameHomeWork;
        this.lectures=lectures;
        calc++;
    }

    public static int getCalcHomeWork() {
        return calc;
    }

    public int getIdHomeWork() {
        return id;
    }

    public String getNameHomeWork() {
        return nameHomeWork;
    }

    public Lecture getLecturesHomeWork() {
        return lectures;
    }

    public Course getCourseIDHomeWork() {
        return courseID;
    }
}
