package com.Univer.service;

public class TeacherService {
    public static int calc;
    private static long id;
    public TeacherService() {
        calc++;
    }

    public static int getCalcTeacherService() {
        return calc;
    }

    public static long getIdTeacherService() {
        return id;
    }
}
