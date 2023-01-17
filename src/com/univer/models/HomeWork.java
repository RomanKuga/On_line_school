package com.univer.models;

public class HomeWork extends MasterModels {
    private static int calc;
    private int lectureId;
    private String task;

    public HomeWork(int id, int lectureId, String task) {
        super(id);
        this.lectureId = lectureId;
        this.task = task;
        calc++;
    }
    public HomeWork(){}

    public static int getCalc() {
        return calc;
    }

    public int getLectureId() {
        return lectureId;
    }

    public String getTask() {
        return task;
    }

    @Override
    public int getID() {
        return super.getID();
    }
}
