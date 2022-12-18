package com.Univer.models;

public class Teacher extends MasterModels{
    private static int calc;
    private int id;
    private String firstName;
    private String secondName;
    private String subject;
    public Teacher( int id, String firstName, String secondName, String subject) {
        super(id);
        this.firstName = firstName;
        this.secondName = secondName;
        this.subject = subject;
        calc++;
    }

    public int getIdTeacher() {
        return id;
    }

    public static int getCalcTeacher() {
        return calc;
    }


    public String getF_nameTeacher() {
        return firstName;
    }

    public String getSecondNameTeacher() {
        return secondName;
    }

    public String getSubjectTeacher() {
        return subject;
    }
}
