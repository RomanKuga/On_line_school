package com.Univer.models;

public class Lecture extends MasterModels {

    private  static int calc;
    private int id;
    private  int courseID;
    private String nameLecture;
    private Course course;
    private int personId;
    public Lecture( int id, int courseID, String nameLecture,int personId) {
        super(id);
        this.id =id;
        this.courseID=courseID;
        this.nameLecture=nameLecture;
        this.personId=personId;
        calc++;
    }
    public Lecture(){

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

    public  void setCalcLecture() {
        calc--;
    }

//    public int getIdLecture() {
//
//        return id;
//    }

    public int getCourseIDLecture() {

        return courseID;
    }

    public String getNameLecture() {

        return nameLecture;
    }

    @Override
    public String toString() {
        return "//  Int object with id = " +  getID()  + "/  CourseID--  " + courseID + "/ NameLecture-- " + nameLecture + "/ PersonID-- " + personId + "//";
    }
}
