package com.Univer.service;

public class CourseService {
    private static int calc;
    private static long id;
    public CourseService() {
        calc++;
    }

    public static int getCalc() {
        return calc;
    }

    public static long getId() {
        return id;
    }
}
