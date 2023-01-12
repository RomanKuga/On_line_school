package com.univer.models;

public class Lecture extends MasterModels {

    private static int calc;
    private int id;
    private static int courseID;
    private String name;
    private String description;
    private int personId;

    public Lecture(int id, int courseID, String name, int personId, String description) {
        super(id);
        this.id = id;
        this.courseID = courseID;
        this.name = name;
        this.personId = personId;
        this.description = description;
        calc++;
    }

    public Lecture() {
    }

    public int getCalcLecture() {
        return calc;
    }

    public int getLecturePersonId() {
        return personId;
    }

    @Override
    public int getID() {
        return super.getID();
    }

    public void setCalcLecture() {
        calc--;
    }

    public static int getCourseIDLecture() {

        return courseID;
    }

    public String getNameLecture() {

        return name;
    }

    @Override
    public String toString() {
        return "//  Int object with id = " + getID() + "/  CourseID--  " + courseID + "/ NameLecture-- " + name +
                "/ PersonID-- " + personId + "/ Description-- " + description + "//";
    }
}
