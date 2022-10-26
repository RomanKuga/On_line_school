package com.Univer.models;

public class Teacher {
    public static int calc;
    private static long id;
    public String f_name;
    public String s_name;
    public String subject;
    public Teacher(String f_name, String s_name, String subject) {
        this.f_name = f_name;
        this.s_name = s_name;
        this.subject = subject;
        calc++;
    }
}
