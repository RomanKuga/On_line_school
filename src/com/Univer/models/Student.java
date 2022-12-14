package com.Univer.models;

public class Student {
    private static int calc;
    private static long id;
    private String f_name;
    private String s_name;
    private Course course;
    private int age;
    public Student(String f_name, String s_name, Course course, int age){
        this.f_name=f_name;
        this.s_name=s_name;
        this.course=course;
        this.age=age;
        calc++;
    }

    public static int getCalcStudent() {
        return calc;
    }

    public static long getIdStudent() {
        return id;
    }

    public String getF_nameStudent() {
        return f_name;
    }

    public String getS_nameStudent() {
        return s_name;
    }

    public Course getCourseStudent() {
        return course;
    }

    public int getAgeStudent() {
        return age;
    }
}
