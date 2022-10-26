package com.Univer.models;

public class Lectures {
    public static int calc;
    private static long id;
    public String nameLecture;
    public Course course;
    public Teacher teacher;
    public  Lectures(String nameLecture, Course course, Teacher teacher) {
        this.nameLecture=nameLecture;
        this.course=course;
        this.teacher=teacher;
        calc++;
    }
}
