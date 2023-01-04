package com.Univer.models;

public class Person extends MasterModels{

    private  static int calc;

    private int courseId;
    private Role role;
    private String firstName;
    private String secondName;
    private int personIDtmp;

    public Person(int personID, int courseId, Role role, String firstName, String secondName ) {
        super(personID);
        this.courseId=courseId;
        this.role= role;
        this.firstName=firstName;
        this.secondName=secondName;
        calc++;
        personIDtmp=personID;

    }
    public Person(){}

    public int getPersonID() {

        return personIDtmp;
    }

    public int getCourseId() {
        return courseId;
    }

    public Role getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public  int getCalcPerson() {
        return calc;
    }
    public void setCalcCorect() {
        calc--;
    }

    @Override
    public String toString() {
        return "//  Person id = " +  getPersonID()  + "/  CourseID--  " + getCourseId() +
                "/ FirstName-- " + getFirstName() + "/ SecondName-- " + getSecondName() + "/ Role-- " + getRole();
    }
}
