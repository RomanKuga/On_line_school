package com.Univer.models;

public class Home_Work {
    public static int calc;
    private static long id;

    public String name_Home_Work;
    public Lectures lectures;
    public Course course;
    public Home_Work(String name_Home_Work, Lectures lectures, Course course) {
        this.name_Home_Work=name_Home_Work;
        this.lectures=lectures;
        this.course=course;
        calc++;
    }
}
