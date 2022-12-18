package com.Univer.models;

public class Lecture extends MasterModels {

    private  static int calc;
    private int id;
    private static int courseID;
    private String nameLecture;
    private Course course;
    private Teacher teacher;
    public Lecture( int id, int courseID, String nameLecture) {
        super(courseID);
        this.id =id;
        this.courseID=courseID;
        this.nameLecture=nameLecture;
        calc++;
    }
    public Lecture(){

    }
        public int getCalcLecture() {

        return calc;
    }

    public int getIdLecture() {

        return id;
    }

    public int getCourseIDLecture() {

        return courseID;
    }

    public String getNameLectureLecture() {

        return nameLecture;
    }

    @Override
    public String toString() {
        return "//  Int object with id = " +  getIdLecture()  + "/  CourseID--  " + courseID + "/ NameLecture-- " + nameLecture;
    }
}
