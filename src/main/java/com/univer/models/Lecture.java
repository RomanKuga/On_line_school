package com.univer.models;

import com.univer.repository.RepositoryHomeWork;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Lecture extends MasterModels implements Serializable {

    @Serial
    private static final long serialVersionUID = 1766929690445523022L;
    private static int calc;
    private   Integer id;
    private static Integer courseID;
    private String name;
    private String description;
    private Integer personId;
    private  LocalDateTime holdingTimeLecture;
     RepositoryHomeWork homeWork;

    public Lecture(Integer id, Integer courseID, String name, Integer personId, String description, RepositoryHomeWork homeWork, LocalDateTime holdingTimeLecture) {
        this.id=id;
        Lecture.courseID = courseID;
        this.name = name;
        this.personId = personId;
        this.description = description;
        this.homeWork=homeWork;
        this.holdingTimeLecture=holdingTimeLecture;
        calc++;
    }

    public  LocalDateTime getHoldingTimeLecture() {
        return holdingTimeLecture;
    }

    public Lecture() {
    }

    public int getCalcLecture() {
        return calc;
    }

    public int getLecturePersonId() {
        return personId;
    }


    public int getID() {
        return id;
    }

    @Override
    public Integer getLectureId() {
        return super.getID();
    }

    public void setCalcLecture() {
        calc--;
    }

    public  int getCourseIDLecture() {

        return courseID;
    }

    public RepositoryHomeWork getHomeWork() {
        return homeWork;
    }

    @Override
    public String toString() {
       if (getHomeWork()!=null) {
           return "//  Int object with id = " + getID() + "/  CourseID--  " + courseID + "/ NameLecture-- " + name +
                   "/ PersonID-- " + personId + "/ Description-- " + description + "/ HomeWork-- є домашнє завдання/"+"Date and time - "+holdingTimeLecture+"\n";
       }else {
           return "//  Int object with id = " + getID() + "/  CourseID--  " + courseID + "/ NameLecture-- " + name +
                   "/ PersonID-- " + personId + "/ Description-- " + description + "/ HomeWork--домашнє завдання відсутнє/"+"Date and time - "+holdingTimeLecture+"\n";
       }
    }
}