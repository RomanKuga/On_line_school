package com.Univer.models;

public class Lectures {
    public static int calc;
    private static long id;
    public String nameLecture;
    public Course course;
    public Teacher teacher;
    public  Lectures(String nameLecture) {
        this.nameLecture=nameLecture;

        calc++;
    }
}
