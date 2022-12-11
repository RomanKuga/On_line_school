package com.Univer.models;

public class Lecture {
    public static int calc;
    private  int id;
    public int courseID;
    public String nameLecture;
    public Course course;
    public Teacher teacher;
    public Lecture( int id, int courseID, String nameLecture) {
        this.id=id;
        this.nameLecture=nameLecture;
        this.courseID=courseID;

        calc++;
    }
    @Override
    public String toString() {
        return "Int object with id = " + id + "  CourseID  " + courseID + " NameLecture " + nameLecture;
    }
}
