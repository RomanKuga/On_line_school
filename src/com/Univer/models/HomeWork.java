package com.Univer.models;

public class HomeWork {
    public static int calc;
    private static long id;

    public String name_Home_Work;
    public Lecture lectures;
    public Course course;
    public HomeWork(String name_Home_Work, Lecture lectures, Course course) {
        this.name_Home_Work=name_Home_Work;
        this.lectures=lectures;
        this.course=course;
        calc++;
    }
}
