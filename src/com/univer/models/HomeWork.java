package com.univer.models;

import java.io.Serial;
import java.io.Serializable;

public class HomeWork extends MasterModels implements Serializable {
    @Serial
    private static final long serialVersionUID = 0x4b2060281738d2a5L;
    private static int calc;
    private Integer lectureId;
    private String task;
    private Integer id;

    public HomeWork(Integer id, Integer lectureId, String task) {
        this.id=id;
        this.lectureId = lectureId;
        this.task = task;
        calc++;
    }
    public HomeWork(){}

    public static int getCalc() {
        return calc;
    }

    public Integer getLectureId() {
        return lectureId;
    }

    public String getTask() {
        return task;
    }


    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return "//  HomeWork id = " +  getID()  + "/ Lecture--  " + getLectureId() + "/ Опис--  " + getTask() + "//" + "\n";
    }
}
