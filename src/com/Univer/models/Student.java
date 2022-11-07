package com.Univer.models;

public class Student {
    public static int calc;
    private static long id;
    public String f_name;
    public String s_name;
    public Course course;
    public int age;
    public Student(String f_name, String s_name, Course course, int age){
        this.f_name=f_name;
        this.s_name=s_name;
        this.course=course;
        this.age=age;
        calc++;
    }
}
