package com.Univer.models;

public class HomeWork {
    private static int calc;
    private static long id;

    private String name_Home_Work;
    private Lecture lectures;
    private Course course;
    public HomeWork(String name_Home_Work, Lecture lectures, Course course) {
        this.name_Home_Work=name_Home_Work;
        this.lectures=lectures;
        this.course=course;
        calc++;
    }

    public static int getCalcHomeWork() {
        return calc;
    }
}
