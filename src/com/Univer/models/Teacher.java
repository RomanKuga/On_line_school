package com.Univer.models;

public class Teacher {
    private static int calc;
    private static long id;
    private String f_name;
    private String s_name;
    private String subject;
    public Teacher(String f_name, String s_name, String subject) {
        this.f_name = f_name;
        this.s_name = s_name;
        this.subject = subject;
        calc++;
    }

    public static int getCalcTeacher() {
        return calc;
    }

    public static long getIdTeacher() {
        return id;
    }

    public String getF_nameTeacher() {
        return f_name;
    }

    public String getS_nameTeacher() {
        return s_name;
    }

    public String getSubjectTeacher() {
        return subject;
    }
}
