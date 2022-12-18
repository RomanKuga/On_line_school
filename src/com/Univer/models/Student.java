package com.Univer.models;

public class Student extends MasterModels{
    private static int calc;
    private int id;
    private String firstName;
    private String secondName;
    private Course course;
    private int age;
    public Student(int id, String firstName, String secondName, Course course, int age){
        super(id);
        this.firstName=firstName;
        this.secondName=secondName;
        this.course=course;
        this.age=age;
        calc++;
    }

    public static int getCalcStudent() {
        return calc;
    }

    public int getIdStudent() {
        return id;
    }

    public String getFirstNameStudent() {
        return firstName;
    }

    public String getSecondNameStudent() {

        return secondName;
    }

    public Course getCourseStudent() {
        return course;
    }

    public int getAgeStudent() {
        return age;
    }
}
