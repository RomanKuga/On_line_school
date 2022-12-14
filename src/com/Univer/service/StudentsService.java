package com.Univer.service;

public class StudentsService {
    public static int calc;
    private static long id;
    public StudentsService() {
        calc++;
    }

    public static int getCalcStudentsService() {
        return calc;
    }

    public static long getIdStudentsService() {
        return id;
    }
}
