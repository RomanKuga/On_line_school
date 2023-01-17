package com.univer.models;

import com.univer.repository.RepositoryHomeWork;

public class Lecture extends MasterModels {

    private static int calc;
    private int id;
    private static int courseID;
    private String name;
    private String description;
    private int personId;
     RepositoryHomeWork homeWork;

    public Lecture(int id, int courseID, String name, int personId, String description, RepositoryHomeWork homeWork) {
        super(id);
        this.courseID = courseID;
        this.name = name;
        this.personId = personId;
        this.description = description;
        this.homeWork=homeWork;
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

    public RepositoryHomeWork getHomeWork() {
        return homeWork;
    }

    @Override
    public String toString() {
       if (getHomeWork()!=null) {
           return "//  Int object with id = " + getID() + "/  CourseID--  " + courseID + "/ NameLecture-- " + name +
                   "/ PersonID-- " + personId + "/ Description-- " + description + "/ HomeWork-- є домашнє завдання//";
       }else {
           return "//  Int object with id = " + getID() + "/  CourseID--  " + courseID + "/ NameLecture-- " + name +
                   "/ PersonID-- " + personId + "/ Description-- " + description + "/ HomeWork--домашнє завдання відсутнє//";
       }
    }
}
